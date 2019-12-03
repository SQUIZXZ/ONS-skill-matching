package com.nsa.ons.onsgroupproject.service;


import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;

import java.util.List;
import java.util.Optional;


public interface UserSkillFinder {


     List<User> findUsersSkillBySkillId(Long skillID);

//    Optional<UserSkill> findById(Long id, Long skillId);


}
