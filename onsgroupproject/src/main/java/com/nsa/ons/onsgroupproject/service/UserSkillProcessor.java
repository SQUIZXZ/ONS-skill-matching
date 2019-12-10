package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillProcessor implements UserSkillFinder {

    private UserSkillRepository userSkillRepository ;


    public UserSkillProcessor (UserSkillRepository aUSRepo){

        userSkillRepository = aUSRepo;
    }

    public List <User> findUsersSkillBySkillId(Long skillID){
        return userSkillRepository.findUserSkillBySkillId(skillID);
    }

//    public Optional<UserSkill> findById(Long id ,Long SkillId){
//        return userSkillRepository.findById(id,SkillId);
//    }

}
