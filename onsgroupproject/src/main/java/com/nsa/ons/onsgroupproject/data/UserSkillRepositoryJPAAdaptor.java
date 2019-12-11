package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import com.nsa.ons.onsgroupproject.service.UserSkillRepository;
import com.nsa.ons.onsgroupproject.service.events.UserSkillMade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSkillRepositoryJPAAdaptor implements UserSkillRepository {

    private UserSkillRepositoryJPA userSkillRepositoryJPA;

    public UserSkillRepositoryJPAAdaptor(UserSkillRepositoryJPA userskillJPARepo) {
        userSkillRepositoryJPA = userskillJPARepo;
    }


//    @Override
//    public List<User> findUserSkillBySkillId(Long SkillId) {
//        return userSkillRepositoryJPA.findUsersSkillBySkillId(SkillId);
//    }

    public void saveUserSkill(UserSkillMade userSkillMade){
        UserSkill newUserSkill = new UserSkill(userSkillMade.getUserID(),userSkillMade.getSkillId(),userSkillMade.getLevel(),userSkillMade.isPrivacy());
        userSkillRepositoryJPA.save(newUserSkill);
    }



}
