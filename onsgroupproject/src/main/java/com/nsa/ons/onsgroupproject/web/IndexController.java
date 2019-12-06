package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRequestFinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class IndexController {
    private SkillRequestFinder skillRequestFinder;

    public IndexController(SkillRequestFinder sRFinder){
        skillRequestFinder = sRFinder;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String homePage(Model model){

        List<SkillRequest> allSkillRequests = skillRequestFinder.findAll();

        model.addAttribute("allRequests",allSkillRequests);

        return "index";
    }
}
