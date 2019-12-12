package com.nsa.ons.onsgroupproject.data;

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
    @Override
    public List<UserSkill> findAllByUser_id(Long id) {
        return userSkillRepositoryJPA.findAllByUser_id(id);
    }

    @Override
    public List <UserSkill>findBySkill_id(Long skillId){
        return userSkillRepositoryJPA.findBySkill_id(skillId);
    }

    public void saveUserSkill(UserSkillMade userSkillMade) {
        UserSkill newUserSkill = new UserSkill(userSkillMade.getUserID(), userSkillMade.getSkillId(), userSkillMade.getLevel(), userSkillMade.getPrivacy());
        userSkillRepositoryJPA.save(newUserSkill);
    }




}
