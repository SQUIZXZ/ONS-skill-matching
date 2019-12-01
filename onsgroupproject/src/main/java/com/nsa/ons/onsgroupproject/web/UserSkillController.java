package com.nsa.ons.onsgroupproject.web;

import java.util.List;
import java.util.Optional;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import com.nsa.ons.onsgroupproject.domain.UserInfo;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class UserSkillController {

    private UserSkillFinder finder;

    public UserSkillController(UserSkillFinder aFinder) {
        finder = aFinder;
    }


    @GetMapping("findContacts},{i}")
    public List<UserInfo > findContactsInfo(@PathVariable("i") Long searchTerm, Model model) {

        List<UserSkill> usersWithSkill;
        Optional<Skill> skill = finder.findSkillByIndex(searchTerm);
        List<Skill> childSkillsList = skill.getChildSkills();

        List<UserInfo > Usercontact;

        childSkillsList.add(skill);
        for (Skill skillList : childSkillsList) {
            List<UserSkill> userSkill = findUsersSkillBySkillId(skillList.get().getId());
            for (UserSkill uSkill : userSkill) {
                UserSkill userSkillPublic = findUserSkillByPrivace(uSkill); {
                    if(userSkillPublic.isPresent()){
                        Usercontact.add(Skill.get() );
                    }
                }
            }
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("Usercontact", Usercontact);
            return Usercontact;
        }
    }
}