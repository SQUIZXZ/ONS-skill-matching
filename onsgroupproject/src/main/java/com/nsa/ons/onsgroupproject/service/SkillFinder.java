package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.Skill;
import java.util.List;
import java.util.Optional;

public interface SkillFinder {

    // Interface between
    public Optional<Skill> findSkillByIndex(Long index);

    public List<Skill> findSkillBySearch(String searchTerm);

}
