package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import com.nsa.ons.onsgroupproject.service.events.UserSkillMade;

import java.util.List;

public interface UserSkillRepository  {

    List <UserSkill>findAllByUser_id(Long userId);

    public void saveUserSkill(UserSkillMade userSkillMade);

//    Optional<UserSkill> findById(Long id, Long skillId);
}
