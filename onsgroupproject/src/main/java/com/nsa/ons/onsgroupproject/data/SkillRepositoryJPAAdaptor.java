package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.SkillRepository;
import com.nsa.ons.onsgroupproject.service.events.SkillMade;

import com.nsa.ons.onsgroupproject.service.events.SkillUpdated;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SkillRepositoryJPAAdaptor implements SkillRepository {

    private SkillRepositoryJPA skillRepositoryJPA;

    public SkillRepositoryJPAAdaptor(SkillRepositoryJPA skillJPARepo) {
        skillRepositoryJPA = skillJPARepo;
    }

    public Optional<Skill> findById(Long id) {
        return skillRepositoryJPA.findById(id);
    }

    public Optional<Skill> findByName(String name) {
        return skillRepositoryJPA.findByName(name);
    }

    @Override
    public List<Skill> findBySearch(String searchTerm) {
        return skillRepositoryJPA.findBySearch(searchTerm);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepositoryJPA.findAll();
    }

    @Override
    public void saveSkill(SkillMade skillMade) {
        Skill s = new Skill(null,skillMade.getSkillName(),skillMade.getSkillDescription(),new ArrayList<>(),skillMade.getParentSkills()/*,null*/);
        skillRepositoryJPA.save(s);

    }
    @Override
    public void  saveSkill(SkillUpdated skillUpdated){
        Skill skillToUpdate = findById(skillUpdated.getSkillID()).get();
        skillToUpdate.setName(skillUpdated.getSkillName());
        skillToUpdate.setDescription(skillUpdated.getSkillDescription());
        skillToUpdate.setParentSkills(skillUpdated.getParentSkills());
        skillRepositoryJPA.save(skillToUpdate);
    }

}
