package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.UserInfo;
import java.util.List;
import java.util.Optional;

public interface UserSkillFinder  {

    public Optional<UserSkill> findUsersInfoBySkill(Long name);
    public Optional<UserSkill>findUserSkillByPrivace(UserSkill userSkill);



}
