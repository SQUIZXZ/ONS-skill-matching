package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.events.SkillMade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillProcessor implements SkillFinder, SkillCreator {

    private SkillRepository skillRepository;

    public SkillProcessor(SkillRepository repo) {
        skillRepository = repo;
    }

    // Finds skill using index
    public Optional<Skill> findSkillByIndex(Long index) {
        return skillRepository.findById(index.longValue());
    }

    public Optional<Skill> findSkillByName(String name) {
        return skillRepository.findByName(name);
    }

    // Finds skill by search
    public List<Skill> findSkillBySearch(String searchTerm) {
        return skillRepository.findBySearch(searchTerm);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public void makeSkill(SkillMade skillMade) {
        skillRepository.saveSkill(skillMade);
    }
}



