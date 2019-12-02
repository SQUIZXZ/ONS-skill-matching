package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.UserInfo;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import com.nsa.ons.onsgroupproject.service.UserSkillFinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
class UserSkillController {

    private UserSkillFinder finder;
    private UserFinder userFinder;
    private SkillFinder skillFinder;

    public UserSkillController(UserSkillFinder aFinder,SkillFinder aSkillFinder) {
        finder = aFinder;
        skillFinder = aSkillFinder;
    }


    @RequestMapping(path = "findContacts/{id}", method = RequestMethod.GET)
    public String findContactsInfo(@PathVariable("id") Long searchTerm, Model model) {

        List<UserSkill> usersWithSkill;
        Optional<Skill> skill = skillFinder.findSkillByIndex(searchTerm);
        List<UserInfo> Usercontact = new ArrayList<>();
        List<UserSkill> userS;
        userS = finder.findUsersSkillBySkillId(searchTerm);

        for (UserSkill uSkill : userS) {
            Boolean userSkillPublic = uSkill.isPrivacy(); {
                    if(userSkillPublic){
                        Usercontact.add(uSkill.getUser_id());
                    }
                }
            }
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("Usercontact", Usercontact);
            return "Usercontact";
        }
    }
}