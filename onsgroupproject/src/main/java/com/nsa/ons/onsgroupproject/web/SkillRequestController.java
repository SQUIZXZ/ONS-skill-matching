package com.nsa.ons.onsgroupproject.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.*;
import com.nsa.ons.onsgroupproject.service.events.SkillMade;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@Slf4j
public class SkillRequestController {

    private SkillRequestCreator skillRequestCreator;
    private SkillRequestFinder skillRequestFinder;
    private SkillFinder skillFinder;
    private SkillCreator skillCreator;

    public SkillRequestController(SkillRequestCreator srCreate, SkillRequestFinder srFinder,
                                  SkillFinder aSkillFinder, SkillCreator aSkillCreator) {
        skillRequestCreator = srCreate;
        skillRequestFinder = srFinder;
        skillFinder = aSkillFinder;
        skillCreator = aSkillCreator;

    }

    @RequestMapping(path = "createSkillRequest", method = RequestMethod.GET)
    public String createSkillRequest(Model model) {
        log.debug("Create skill request accessed");
        model.addAttribute("skillRequestForm", new SkillRequestForm());
        List<Skill> skills = skillFinder.findAll();
        ArrayList<String> skillsNoId = new ArrayList<>();
        for (Skill s : skills) {
            skillsNoId.add(s.getName());
        }
        model.addAttribute("skills", skillsNoId);
        return "requestFormPage";
    }

    //    @RequestMapping(path = "saveSkillRequest", method = RequestMethod.POST)
//    public String confirmSkillRequest(@ModelAttribute("skillRequestForm") @Valid SkillRequestForm skillRequest,
//                                   Model model,
//                                   BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            log.debug("Binding Errors Found");
//            return "RequestFormPage";
//        }
//
//        log.debug("saving skill request");
//        SkillRequestMade skillRequestMade = new SkillRequestMade(
//                skillRequest.getFirstName(),
//                skillRequest.getSurname(),
//                skillRequest.getDepartment(),
//                skillRequest.getSkill(),
//                skillRequest.getTaskDescription(),
//                skillRequest.getFurl()
//        );
//        skillRequestRepository.saveSkillRequest(skillRequestMade);
//
//        model.addAttribute("skillRequest",skillRequestRepository.findByFurl(skillRequest.getFurl()).get());
//        return "RequestPage";
//
//
//    }

    @RequestMapping(path = "saveSkillRequest", method = RequestMethod.POST)
    public ResponseEntity<?> saveSkillRequest(@RequestBody @Valid SkillRequestForm skillRequestForm,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Binding Errors Found");
            String messages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                messages += error.getDefaultMessage() + ", ";
            }
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messages.substring(0, messages.length() - 2));
        }

        String firstName = skillRequestForm.getFirstName();
        String surname = skillRequestForm.getSurname();
        String department = skillRequestForm.getDepartment();
        String skill = skillRequestForm.getSkill();
        String description = skillRequestForm.getTaskDescription();
        String furl = skillRequestForm.getFurl();
        if (skillRequestFinder.findSkillRequestByFurl(furl).isPresent()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("furlExists");
        }

        SkillRequestMade skillRequest = new SkillRequestMade(firstName, surname, department, skill, description, furl);
        skillRequestCreator.makeSkillRequest(skillRequest);
        return ResponseEntity.status(HttpStatus.OK).body(furl);
    }

    @RequestMapping(path = "saveNewSkill", method = RequestMethod.POST)
    public ResponseEntity<?> saveNewSkill(@RequestBody @Valid SkillCreationForm skillCreationForm,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Binding Errors Found");
            String messages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                messages += error.getDefaultMessage() + ", ";
            }
            log.debug(messages);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messages.substring(0, messages.length() - 2));
        }

        Optional<Skill> parentSkill = skillFinder.findSkillByName(skillCreationForm.getParent());
        if(parentSkill.isPresent()){
            List<Skill> skills = new ArrayList<>();
            if(parentSkill.isPresent()){
                skills.add(parentSkill.get());
                SkillMade sm = new SkillMade(skillCreationForm.getSkill(), skills);
                skillCreator.makeSkill(sm);
            }else{
                SkillMade sm = new SkillMade(skillCreationForm.getSkill(), null);
                skillCreator.makeSkill(sm);
            }
        }else{
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillExist");
        }


        return ResponseEntity.status(HttpStatus.CREATED).body("Added to DB");
    }

    @RequestMapping(path = "skillRequest/{furl}", method = RequestMethod.GET)
    public String skillRequest(@PathVariable("furl") String furl, Model model) {
        Optional<SkillRequest> skillRequest = skillRequestFinder.findSkillRequestByFurl(furl);
        if (skillRequest.isEmpty()) {
            log.debug("failed to find skill request");
            return "404ErrorPage";
        }
        model.addAttribute("skillRequest", skillRequest.get());
        return "requestPage";
    }

}
