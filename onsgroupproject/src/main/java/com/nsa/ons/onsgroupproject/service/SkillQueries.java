package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.Skill;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SkillQueries implements SkillFinder {

    private SkillRepository skillRepository;

    public SkillQueries(SkillRepository repo) {
        skillRepository = repo;
    }

    // Finds skill using index
    public Optional<Skill> findSkillByIndex(Long index) {
        return skillRepository.findById(index.longValue());
    }

    // Finds skill by search
    public List<Skill> findSkillBySearch(String searchTerm) {
        return skillRepository.findBySearch(searchTerm);

    }

}



