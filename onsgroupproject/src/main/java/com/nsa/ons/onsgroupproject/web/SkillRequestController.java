package com.nsa.ons.onsgroupproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SkillRequestController {

    static final Logger log = LoggerFactory.getLogger(SkillRequestController.class);

    @RequestMapping(path = "skillRequest/{furl}", method = RequestMethod.GET)
    public String skillRequest(@PathVariable("furl") String furl, Model model) {
        model.addAttribute("furl", furl);
        return "RequestPage";
    }

    @RequestMapping(path = "createSkillRequest", method = RequestMethod.GET)
    public String createSkillRequest(Model model){
        log.debug("Create skill request accessed");

        model.addAttribute("skillRequestForm", new SkillRequestForm());

        return "RequestFormPage";
    }

}
