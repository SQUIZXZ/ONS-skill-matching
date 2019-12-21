package com.nsa.ons.onsgroupproject.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.SkillRequest;

import com.nsa.ons.onsgroupproject.service.events.SkillMade;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;

import com.nsa.ons.onsgroupproject.service.SkillCreator;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import com.nsa.ons.onsgroupproject.service.SkillRequestCreator;
import com.nsa.ons.onsgroupproject.service.SkillRequestFinder;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (skillRequestFinder.findSkillRequestByFurl(furl).isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("furlExists");
        }
        if (!skillFinder.findSkillByName(skill).isPresent()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillExists");
        }

        SkillRequestMade skillRequest = new SkillRequestMade(firstName, surname, department, skill, description, furl);
        skillRequestCreator.makeSkillRequest(skillRequest);
        //This is bad practise but was requested by the user
        Optional<SkillRequest> skillRequestByFurl = skillRequestFinder.findSkillRequestByFurl(furl);
        Long id = skillRequestByFurl.get().getId();
        String data = (id+","+furl);
        return ResponseEntity.status(HttpStatus.OK).body(data);
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
        Optional<Skill> childSkill = skillFinder.findSkillByName(skillCreationForm.getSkill());
        Optional<Skill> parentSkill = skillFinder.findSkillByName(skillCreationForm.getParent());
        if (!childSkill.isPresent()) {
            if (parentSkill.isPresent()) {
                List<Skill> skills = new ArrayList<>();
                skills.add(parentSkill.get());
                SkillMade sm = new SkillMade(skillCreationForm.getSkill(),skillCreationForm.getDescription(), skills);
                skillCreator.makeSkill(sm);
                return ResponseEntity.status(HttpStatus.CREATED).body("Added to DB");
            } else if (skillCreationForm.getParent().equals("")) {
                SkillMade sm = new SkillMade(skillCreationForm.getSkill(),skillCreationForm.getDescription(), null);
                skillCreator.makeSkill(sm);
                return ResponseEntity.status(HttpStatus.CREATED).body("Added to DB");
            } else {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillParentExist");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillChildExist");
        }

    }

    @RequestMapping(path = "skillRequest/{furl}/{id}", method = RequestMethod.GET)
    public String skillRequest(@PathVariable("furl") String furl,@PathVariable("id") Long id, Model model) {
        Optional<SkillRequest> skillRequest = skillRequestFinder.findSkillRequestByFurl(furl);
        if (skillRequest.isEmpty()) {
            log.debug("failed to find skill request");
            return "404ErrorPage";
        } else {
            if(!skillRequest.get().getId().equals(id)){
                log.debug("failed to find skill request");
                return "404ErrorPage";
            }
        }
        model.addAttribute("skillRequest", skillRequest.get());
        return "requestPage";
    }

}
