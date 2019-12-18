package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
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

    @Override
    public List<UserSkill> findAllByUser_id(Long userId) {
        return userSkillRepository.findAllByUser_id(userId);
    }

    @Override
    public List<UserSkill> findBySkill_id(Long userId) {
        return userSkillRepository.findBySkill_id(userId);
    }


//    public Optional<UserSkill> findById(Long id ,Long SkillId){
//        return userSkillRepository.findById(id,SkillId);
//    }

}
