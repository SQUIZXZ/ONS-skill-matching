package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillRepository {

    // Skill interface methods for finding charity, based on the following:
    public Optional<Skill> findById(Long id); //change parameter to a Long.  JPA convention that it matches the type of the @Id

    public List<Skill> findBySearch(String searchTerm);

    public int findByName(String name);

   //public List<UserInfo> findUsersBySkill(String searchTerm);
}
