package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.UserSkillRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

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
