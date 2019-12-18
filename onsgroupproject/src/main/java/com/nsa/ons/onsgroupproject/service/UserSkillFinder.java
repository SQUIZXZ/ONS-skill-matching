package com.nsa.ons.onsgroupproject.service;


import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;

import java.util.List;


public interface UserSkillFinder {


//     List<User> findUsersSkillBySkillId(Long skillID);
       List <UserSkill>findAllByUser_id(Long userId);
       List <UserSkill> findBySkill_id (Long SkillId);
//    Optional<UserSkill> findById(Long id, Long skillId);


}
