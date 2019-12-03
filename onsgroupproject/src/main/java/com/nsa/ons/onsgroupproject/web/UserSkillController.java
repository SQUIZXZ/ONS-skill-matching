package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import com.nsa.ons.onsgroupproject.service.UserFinder;
import com.nsa.ons.onsgroupproject.service.UserSkillFinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
class UserSkillController {

    private UserFinder userFinder;
    private UserSkillFinder finder ;
    private SkillFinder skillFinder ;



    public UserSkillController(SkillFinder Skillfinder ,UserSkillFinder aFinder ,UserFinder auserFinder ) {
        finder = aFinder;
        skillFinder  =Skillfinder;
        userFinder  = auserFinder;
    }

    @GetMapping("findContacts")
    public String findContactsInfo( Long SkillID, Model model) {

        List<UserSkill> usersWithSkill;
        Optional<Skill> skill = skillFinder.findSkillByIndex(SkillID);
        List<Optional<User>> Usercontact = new ArrayList<>();
        List<UserSkill> userS;
        List<Optional<UserSkill>> userSkillList = null;

//        for (UserSkill uSkill : userS) {
//            Optional<UserSkill> userSkillPublic = finder.findUserSkillByPrivacy(uSkill);
//            {
//                    if(userSkillPublic.isPresent()){
//
//                        Usercontact.add(userFinder.findById(uSkill.getUser_id()));
//                     //    System.out.print(uSkill.toString());
//                     //   usersSC =new Pair <User, UserSkill> (userFinder.findById(id), finder.findById(id ,uSkill.getSkill_id()));
//                    }
//
//                }
//            }
//            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("Usercontact", Usercontact);
            model.addAttribute("UsersSkill", userSkillList);

            return "Usercontact";
        }
    }
