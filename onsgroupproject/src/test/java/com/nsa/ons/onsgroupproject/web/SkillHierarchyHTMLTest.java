package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.config.security.MyUserDetailsService;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.SkillFinder;
import com.nsa.ons.onsgroupproject.service.SkillRepository;
import com.nsa.ons.onsgroupproject.service.SkillUpdater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(SkillController.class)
public class SkillHierarchyHTMLTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SkillFinder skillFinder;

    @MockBean
    private SkillUpdater skillUpdater;


    @MockBean
    private MyUserDetailsService myUserDetailsService;

    @Test
    @WithMockUser(value = "Mock")
    public void skillPageHierarchiesTest() throws Exception {

        Skill skillParent = new Skill(1L, "ParentSkill", null, null);
        Skill skillChild = new Skill(2L, "ChildSkill", null, null);
        Skill thisSkill = new Skill(3L, "This Skill", null, null);

        ArrayList<Skill> containsParent = new ArrayList<Skill>();
        ArrayList<Skill> containsChild = new ArrayList<Skill>();
        ArrayList<Skill> containsThis = new ArrayList<Skill>();

        containsParent.add(skillParent);
        containsChild.add(skillChild);
        containsThis.add(thisSkill);

        skillParent.setChildSkills(containsThis);
        skillChild.setParentSkills(containsThis);
        thisSkill.setParentSkills(containsParent);
        thisSkill.setChildSkills(containsChild);

        given(this.skillFinder.findSkillByIndex(1L)).willReturn(Optional.of(skillParent));
        given(this.skillFinder.findSkillByIndex(2L)).willReturn(Optional.of(skillChild));
        given(this.skillFinder.findSkillByIndex(3L)).willReturn(Optional.of(thisSkill));

        mvc.perform(
                get("/skill/3")
        ).andDo(
                print()
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString("Parent Skills"))
        ).andExpect(
                content().string(containsString("Child Skills"))
        ).andExpect(
                content().string(containsString("ParentSkill"))
        ).andExpect(
                content().string(containsString("ChildSkill"))
        );
    }
}
