package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.UserSkill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserSkillProcessor implements UserSkillFinder {
    private UserSkillRepository userSkillRepository;

    public UserSkillProcessor (UserSkillRepository aUSRepo){
        userSkillRepository = aUSRepo;
    }

    public Optional<UserSkill> findUserSkillByPrivacy(UserSkill userSkill){
        return userSkillRepository.findUserSkillByPrivacy(userSkill);
    }

    public List<UserSkill> findUsersSkillBySkillId(Long id){
        return userSkillRepository.findUsersSkillBySkillId(id);
    }
}
