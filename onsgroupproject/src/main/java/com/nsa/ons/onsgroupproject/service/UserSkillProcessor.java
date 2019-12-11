package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.events.UserSkillMade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillProcessor implements UserSkillFinder,UserSkillCreator {

    private UserSkillRepository userSkillRepository ;


    public UserSkillProcessor (UserSkillRepository aUSRepo){

        userSkillRepository = aUSRepo;
    }

//    public List <User> findUsersSkillBySkillId(Long skillID){
//        return userSkillRepository.findUserSkillBySkillId(skillID);
//    }

    public void saveUserSkill(UserSkillMade userSkillMade){
        userSkillRepository.saveUserSkill(userSkillMade);
    }



//    public Optional<UserSkill> findById(Long id ,Long SkillId){
//        return userSkillRepository.findById(id,SkillId);
//    }

}
