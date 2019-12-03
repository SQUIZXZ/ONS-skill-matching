package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import com.nsa.ons.onsgroupproject.service.UserSkillRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserSkillRepositoryJPAAdaptor implements UserSkillRepository {

    private UserSkillRepositoryJPA userSkillRepositoryJPA;

    public UserSkillRepositoryJPAAdaptor(UserSkillRepositoryJPA userskillJPARepo) {
        userSkillRepositoryJPA = userskillJPARepo;
    }


    @Override
    public List<User> findUserSkillBySkillId(Long SkillId) {
        return userSkillRepositoryJPA.findUsersSkillBySkillId(SkillId);
    }



}
