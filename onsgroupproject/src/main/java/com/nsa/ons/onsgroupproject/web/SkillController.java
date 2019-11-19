package com.nsa.ons.onsgroupproject.web;

import java.util.List;

import com.nsa.ons.onsgroupproject.data.RestRepository;
import com.nsa.ons.onsgroupproject.domain.Skill;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SkillController {

    private final RestRepository repository;

    SkillController(RestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/skills")
    List<Skill> all() {
        return repository.findAll();
    }

    @PostMapping("/skills")
    Skill newSkill(@RequestBody Skill newSkill) {
        return repository.save(newSkill);
    }

    @GetMapping("/skills/{id}")
    Skill one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new SkillNotFoundException(id));
    }

    @GetMapping("/skill/{name}")
    List<Skill> one(@PathVariable String name) {

        return repository.findByName(name);

    }

    @PutMapping("/skills/{id}")
    Skill replaceSkill(@RequestBody Skill newSkill, @PathVariable Long id) {

        return repository.findById(id)
                .map(skill -> {
                    skill.setName(newSkill.getName());
                    return repository.save(skill);
                })
                .orElseGet(() -> {
                    newSkill.setId(id);
                    return repository.save(newSkill);
                });
    }

    @DeleteMapping("/skills/{id}")
    void deleteSkill(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

