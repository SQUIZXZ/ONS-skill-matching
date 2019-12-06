package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;

import java.util.List;

public interface UserSkillRepository  {

    List <User>findUserSkillBySkillId(Long skillId);
//    Optional<UserSkill> findById(Long id, Long skillId);
}
