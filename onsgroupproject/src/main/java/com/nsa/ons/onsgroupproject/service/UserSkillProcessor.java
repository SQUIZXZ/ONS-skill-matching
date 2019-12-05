package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
