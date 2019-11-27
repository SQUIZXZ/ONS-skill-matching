package com.nsa.ons.onsgroupproject.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import com.nsa.ons.onsgroupproject.service.SkillRequestCreator;
import com.nsa.ons.onsgroupproject.service.SkillRequestFinder;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import com.nsa.ons.onsgroupproject.service.events.SkillMade;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class SkillRequestController {

    static final Logger log = LoggerFactory.getLogger(SkillRequestController.class);
    private SkillRequestCreator skillRequestCreator;
    private SkillRequestFinder skillRequestFinder;

    public SkillRequestController(SkillRequestCreator srCreate, SkillRequestFinder srFinder) {
        skillRequestCreator = srCreate;
        skillRequestFinder = srFinder;

    }

    @RequestMapping(path = "createSkillRequest", method = RequestMethod.GET)
    public String createSkillRequest(Model model){
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
    public ResponseEntity<?> saveSkillRequest(@RequestBody JsonNode data) {
        String firstName = data.get("firstName").asText();
        String surname = data.get("surname").asText();
        String department = data.get("department").asText();
        String skill =  data.get("skill").asText();
        String description = data.get("description").asText();
        String furl = data.get("furl").asText();
        SkillRequestMade skillRequest = new SkillRequestMade(firstName,surname,department,skill,description,furl);
        skillRequestCreator.makeSkillRequest(skillRequest);
        return ResponseEntity.status(HttpStatus.OK).body(furl);
    }

    @RequestMapping(path = "saveNewSkill", method = RequestMethod.POST)
    public ResponseEntity<?> saveNewSkill(@RequestBody JsonNode node) {
        System.out.println(node);
        String child = node.get("skill").asText();
        String parent = node.get("parent").asText();
        Optional<Skill> parentSkill = skillFinder.findSkillByName(parent);
        List<Skill> skills = new ArrayList<>();
        skills.add(parentSkill.get());
        SkillMade sm = new SkillMade(child,skills);
        skillCreator.makeSkill(sm);
        return ResponseEntity.status(HttpStatus.CREATED).body("Added to DB");
    }

    @RequestMapping(path = "skillRequest/{furl}", method = RequestMethod.GET)
    public String skillRequest(@PathVariable("furl") String furl, Model model) {
        Optional<SkillRequest> skillRequest = skillRequestFinder.findSkillRequestByFurl(furl);
        if(skillRequest.isEmpty()){
            log.debug("failed to find skill request");
            return "404ErrorPage";
        }
        model.addAttribute("skillRequest",skillRequest.get());
        return "requestPage";
    }

}
