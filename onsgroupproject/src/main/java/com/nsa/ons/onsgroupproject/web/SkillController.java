package com.nsa.ons.onsgroupproject.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import com.nsa.ons.onsgroupproject.service.SkillUpdater;
import com.nsa.ons.onsgroupproject.service.UserSkillFinder;
import com.nsa.ons.onsgroupproject.service.events.SkillUpdated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@Controller
@Slf4j
class SkillController {

    private SkillFinder finder;
    private SkillUpdater skillUpdater;
    private UserSkillFinder userSkillFinder ;

    public SkillController(SkillFinder aFinder, SkillUpdater aSkillUpdate,UserSkillFinder uSFinder) {
        finder = aFinder;
        skillUpdater = aSkillUpdate;
        userSkillFinder = uSFinder;
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

        @RequestMapping(path = "/skill/editSkill/{id}", method = RequestMethod.GET)
        public String editSkill(@PathVariable("id")Long skillID,Model model){
            Optional<Skill> editedSkill = finder.findSkillByIndex(skillID);
            if(editedSkill.isEmpty()){
                return "404ErrorPage";
            }
            List<Skill> allSkills = finder.findAll();
            model.addAttribute("allSkills", allSkills);
            model.addAttribute("editingSkill",editedSkill.get());
            return "skillEditPage";
        }

        @RequestMapping(path = "/saveSkillEdit", method = RequestMethod.POST)
        public ResponseEntity<?> saveSkillEdit(@RequestBody @Valid SkillEditForm skillEditForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("edit skill has binding errors");
            String messages = "";
            for(ObjectError error: bindingResult.getAllErrors()){
                messages += error.getDefaultMessage() + ", ";
            }
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messages.substring(0, messages.length() - 2));
        }
        Optional<Skill> skillTaken = finder.findSkillByName(skillEditForm.getSkillName());
        Optional<Skill> thisSkill = finder.findSkillByIndex(skillEditForm.getId());

        if(skillTaken.isPresent()){
            if(!skillTaken.get().getName().equals(thisSkill.get().getName())) {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillNameTaken");
            }
        }
        List<Skill> parentSkillList = new ArrayList<>();
        List<Skill> childSkillList = thisSkill.get().getChildSkills();
        for(int i = 0; i<skillEditForm.getParentSkills().size(); i++){
            Optional<Skill> possibleParent = finder.findSkillByName(skillEditForm.getParentSkills().get(i));
            if(possibleParent.isPresent()) {
                if(!possibleParent.get().equals(thisSkill.get())) {
                    Boolean inParentList = false;
                    for(int x = 0; x<parentSkillList.size();x++){
                        if(parentSkillList.get(x).equals(possibleParent.get())){
                            inParentList = true;
                        }
                    }
                    Boolean inChildList = false;
                    for(int y = 0; y<childSkillList.size(); y++){
                        if(childSkillList.get(y).equals(possibleParent.get())){
                            inChildList = true;
                        }
                    }
                    if(inParentList) {
                        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillCannotBeParentTwice");
                    } else if(inChildList) {
                        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillCannotBeParentAndChild");
                    } else {
                        parentSkillList.add(finder.findSkillByName(skillEditForm.getParentSkills().get(i)).get());
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("skillCannotBeOwnParent");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("parentSkillDoesNotExist");
            }
        }
        SkillUpdated skillUpdated = new SkillUpdated(skillEditForm.getId(),skillEditForm.getSkillName(),skillEditForm.getSkillDescription(),parentSkillList);
        skillUpdater.updateSkill(skillUpdated);

        return ResponseEntity.status(HttpStatus.CREATED).body("Updated Database");
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


