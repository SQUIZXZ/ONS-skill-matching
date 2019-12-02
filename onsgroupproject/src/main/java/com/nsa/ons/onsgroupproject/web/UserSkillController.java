package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.UserInfo;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
class UserSkillController {

    private UserSkillFinder finder;

    public UserSkillController(UserSkillFinder aFinder) {
        finder = aFinder;
    }


    @GetMapping("findContacts},{i}")
    public string findContactsInfo(@PathVariable("i") long searchTerm, Model model) {

        List<UserSkill> usersWithSkill;
        Optional<Skill> skill = finder.findSkillByIndex(searchTerm);
        List<Skill> childList = skill.getChildSkills();

        List<UserInfo > Usercontact;
        List<UserSkill> userS;
        childSkillsList.add(skill);
        for (Skill skillList : childList) {

            userS = finder.findUsersSkillBySkillId(skillList.get().getId());

            for (UserSkill uSkill : userS) {
                UserSkill userSkillPublic = finder.findUserSkillByPrivace(uSkill); {
                    if(userSkillPublic.isPresent()){
                        Usercontact.add(Skill.get() );
                    }
                }
            }
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("Usercontact", Usercontact);
            return "Usercontact";
        }
    }
}