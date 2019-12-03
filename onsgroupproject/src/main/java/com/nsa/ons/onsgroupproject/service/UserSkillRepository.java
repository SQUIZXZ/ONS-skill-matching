package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

import java.util.List;
import java.util.Optional;

public interface UserSkillRepository  {

    public List<UserSkill> findUsersSkillBySkillId(Long searchTerm);

    public Optional<UserSkill>findUserSkillByPrivacy (UserSkill userSkill);

    Optional<UserSkill> findById(Long id, Long skillId);
}
