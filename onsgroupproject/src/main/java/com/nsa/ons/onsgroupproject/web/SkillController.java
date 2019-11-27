package com.nsa.ons.onsgroupproject.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.domain.UserInfo;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import com.nsa.ons.onsgroupproject.service.SkillRepository;
import com.nsa.ons.onsgroupproject.service.UserRepository;
import com.nsa.ons.onsgroupproject.service.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;

@Controller
class SkillController {

    private SkillFinder finder;
    @Autowired
    SkillRepository repo;
    @Autowired
    UserRepository UserRepo;
    @Autowired
    UserSkillRepository userSkillReop;


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
    @GetMapping("findUser")
    public String findUsers(@RequestParam("search") String searchTerm, Model model) {
        int id =repo.findByName(searchTerm);
        List<UserSkill> UserId = userSkillReop.findBySkill_Id(id);
        ArrayList<UserInfo> usersL = new ArrayList <> ();
        ArrayList<Integer> userRanks = new ArrayList<>();
        for(int uid = 0; uid < UserId.size(); uid++ ){
           Optional<UserInfo> info = UserRepo.findById(UserId.get(uid).User_id);
                if (info.get().privacy == true)
                    usersL.add(info.get());
                    userRanks.add(UserId.get(uid).level);

                    
        }

        model.addAttribute("userContacts", usersL);
        model.addAttribute("userLevels",userRanks);



        return "users";

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


