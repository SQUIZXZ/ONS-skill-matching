package com.nsa.ons.onsgroupproject.web;

import java.util.List;
import java.util.Optional;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class SkillController {

    private SkillFinder finder;

    public SkillController(SkillFinder aFinder) {
        finder = aFinder;
    }

    // If skill index exists for add it to the model and return it
    @GetMapping("skill/{i}")
    public String showSkillPage(@PathVariable("i") Long index, Model model) {

        Optional<Skill> skill = finder.findSkillByIndex(index);

        if (skill.isPresent()) {
            model.addAttribute("skill", skill.get());
            return "skill";

        } else {
            return "404ErrorPage";
        }
    }

        @GetMapping("findSkill")
        public String findSkill(@RequestParam("search") String searchTerm, Model model) {

            List<Skill> skills = finder.findSkillBySearch(searchTerm);

            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("skills", skills);
            return "skillList";

        }
}
//    private final SkillRepositoryJPA repository;
//
//    SkillController(SkillRepositoryJPA repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping("/skills")
//    List<Skill> all() {
//        return repository.findAll();
//    }
//
//    @PostMapping("/skills")
//    Skill newSkill(@RequestBody Skill newSkill) {
//        return repository.save(newSkill);
//    }
//
//    @GetMapping("/skills/{id}")
//    Skill one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new SkillNotFoundException(id));
//    }
//
//    @GetMapping("/skill/{name}")
//    List<Skill> one(@PathVariable String name) {
//
//        return repository.findByName(name);
//
//    }
//
//    @PutMapping("/skills/{id}")
//    Skill replaceSkill(@RequestBody Skill newSkill, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(skill -> {
//                    skill.setName(newSkill.getName());
//                    return repository.save(skill);
//                })
//                .orElseGet(() -> {
//                    newSkill.setId(id);
//                    return repository.save(newSkill);
//                });
//    }
//
//    @DeleteMapping("/skills/{id}")
//    void deleteSkill(@PathVariable Long id) {
//        repository.deleteById(id);
//    }


