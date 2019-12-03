package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;

import java.util.List;

import java.util.Optional;

public interface UserSkillRepository  {

    List <User>findUserSkillBySkillId(Long skillId);
//    Optional<UserSkill> findById(Long id, Long skillId);
}
