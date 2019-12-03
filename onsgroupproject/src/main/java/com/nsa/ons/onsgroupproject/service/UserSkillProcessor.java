package com.nsa.ons.onsgroupproject.service;

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

    public Optional<UserSkill> findUserSkillByPrivacy(UserSkill userSkill){
        return userSkillRepository.findUserSkillByPrivacy(userSkill);
    }

    public List<UserSkill> findUsersSkillBySkillId(Long id){
        return userSkillRepository.findUsersSkillBySkillId(id);

    }
    public Optional<UserSkill> findById(Long id ,Long SkillId){
        return userSkillRepository.findById(id,SkillId);
    }
}
