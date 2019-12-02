package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.UserInfo;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import java.util.List;
import java.util.Optional;

public interface UserSkillFinder  {

    public Optional<UserSkill> findUserSkillByPrivacy (UserSkill userSkill);

    public List<UserSkill> findUsersSkillBySkillId(Long searchTerm);


}
