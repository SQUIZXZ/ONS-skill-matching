package com.nsa.ons.onsgroupproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SkillRequestController {

    @RequestMapping(path = "skillRequest", method = RequestMethod.GET)
    public String skillRequest() {

        return "RequestPage";
    }

}
