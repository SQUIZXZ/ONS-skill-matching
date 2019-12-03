package com.nsa.ons.onsgroupproject.service;


import com.nsa.ons.onsgroupproject.domain.UserSkill;
import java.util.List;
import java.util.Optional;


public interface UserSkillFinder {

    public List<UserSkill> findUsersSkillBySkillId(Long searchTerm);

    public Optional<UserSkill>findUserSkillByPrivacy (UserSkill userSkill);

    Optional<UserSkill> findById(Long id, Long skillId);


}
