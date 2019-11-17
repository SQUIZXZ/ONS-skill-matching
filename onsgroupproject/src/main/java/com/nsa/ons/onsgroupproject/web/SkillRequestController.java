package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SkillRequestController {

    static final Logger log = LoggerFactory.getLogger(SkillRequestController.class);

    public SkillRequestController() {

    }

    @RequestMapping(path = "createSkillRequest", method = RequestMethod.GET)
    public String createSkillRequest(Model model){
        log.debug("Create skill request accessed");
        model.addAttribute("skillRequestForm", new SkillRequestForm());
        return "RequestFormPage";
    }

    @RequestMapping(path = "saveSkillRequest", method = RequestMethod.GET)
    public String saveSkillRequest(@ModelAttribute("donor") @Valid SkillRequestForm skillRequestForm, Model model) {
        System.out.println(skillRequestForm);
        return skillRequestForm.toString();
    }

    @RequestMapping(path = "skillRequest/{furl}", method = RequestMethod.GET)
    public String skillRequest(@PathVariable("furl") String furl, Model model) {
        model.addAttribute("furl", furl);
        return "RequestPage";
    }

}
