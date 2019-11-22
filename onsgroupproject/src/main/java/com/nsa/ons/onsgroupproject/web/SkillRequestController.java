package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRepository;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class SkillRequestController {

    static final Logger log = LoggerFactory.getLogger(SkillRequestController.class);
    private SkillRequestRepository skillRequestRepository;
    private SkillRepository skillRepository;

    public SkillRequestController(SkillRequestRepository srRepository, SkillRepository sRepository) {
        skillRequestRepository = srRepository;
        skillRepository = sRepository;

    }

    @RequestMapping(path = "createSkillRequest", method = RequestMethod.GET)
    public String createSkillRequest(Model model){
        log.debug("Create skill request accessed");
        model.addAttribute("skillRequestForm", new SkillRequestForm());
        model.addAttribute("skills", skillRepository.findAll());
        return "RequestFormPage";
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
    public ResponseEntity<?> saveSkillRequest(@RequestBody String formData) {
        List<String> values = Arrays.asList(formData.split(","));
        String firstName = values.get(0).substring(14,values.get(0).length() -1);
        String surname = values.get(1).substring(11,values.get(1).length() -1);
        String department = values.get(2).substring(14,values.get(2).length() -1);
        String skill =  values.get(3).substring(9,values.get(3).length() -1);
        String description = values.get(4).substring(15,values.get(4).length() -1);
        String furl = values.get(5).substring(8,values.get(5).length() -2);
        SkillRequestMade skillRequest = new SkillRequestMade(firstName,surname,department,skill,description,furl);
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
