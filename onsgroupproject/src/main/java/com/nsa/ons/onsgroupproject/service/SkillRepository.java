package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.events.SkillMade;
import com.nsa.ons.onsgroupproject.service.events.SkillUpdated;

import java.util.List;
import java.util.Optional;

public interface SkillRepository {

    // Skill interface methods for finding charity, based on the following:
    public Optional<Skill> findById(Long id); //change parameter to a Long.  JPA convention that it matches the type of the @Id

    public Optional<Skill> findByName(String name);

    public List<Skill> findBySearch(String searchTerm);

    public List<Skill> findAll();

    public void saveSkill(SkillMade skill);

    public void saveSkill(SkillUpdated skillUpdated);


}
