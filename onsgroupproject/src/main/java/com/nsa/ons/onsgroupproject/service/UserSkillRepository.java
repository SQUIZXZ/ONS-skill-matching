package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

import java.util.List;

public interface UserSkillRepository  {

    public Optional<UserSkill> findUsersSkillBySkillId(long searchTerm);

    public Optional<UserSkill>findUserSkillByPrivace (UserSkill userSkill);


}
