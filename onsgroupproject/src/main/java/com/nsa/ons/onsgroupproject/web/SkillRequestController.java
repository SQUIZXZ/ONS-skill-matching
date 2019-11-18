package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class SkillRequestController {

    static final Logger log = LoggerFactory.getLogger(SkillRequestController.class);
    private SkillRequestRepository skillRequestRepository;

    public SkillRequestController(SkillRequestRepository srRepository) {
        skillRequestRepository = srRepository;

    }

    @RequestMapping(path = "createSkillRequest", method = RequestMethod.GET)
    public String createSkillRequest(Model model){
        log.debug("Create skill request accessed");
        model.addAttribute("skillRequestForm", new SkillRequestForm());
        return "RequestFormPage";
    }

//    @RequestMapping(path = "saveSkillsRequest", method = RequestMethod.POST)
//    public String saveSkillRequest(@ModelAttribute("skillRequestForm") SkillRequestForm skillRequest, Model model){
//
//    }


    @RequestMapping(path = "saveSkillRequest", method = RequestMethod.POST)
    public ResponseEntity<?> saveSkillRequest(@RequestBody String formData) {
        List<String> values = Arrays.asList(formData.split("&"));
        System.out.println(values);
        String firstName = values.get(0).substring(10);
        String surname = values.get(1).substring(8);
        String department = values.get(2).substring(11);
        String skill = values.get(3).substring(6);
        String description = values.get(4).substring(12);
        String furl = values.get(5).substring(5);
        SkillRequest skillRequest = new SkillRequest(null,firstName,surname,department,skill,description,furl);
        skillRequestRepository.saveSkillRequest(skillRequest);
        return ResponseEntity.status(HttpStatus.OK).body(furl);
    }

    @RequestMapping(path = "skillRequest/{furl}", method = RequestMethod.GET)
    public String skillRequest(@PathVariable("furl") String furl, Model model) {
        Optional<SkillRequest> skillRequest = skillRequestRepository.findByFurl(furl);
        if(skillRequest.isEmpty()){
            log.debug("failed to find skill request");
            return "404ErrorPage";
        }

        model.addAttribute("skillRequest",skillRequest.get());
        return "RequestPage";
    }

}
