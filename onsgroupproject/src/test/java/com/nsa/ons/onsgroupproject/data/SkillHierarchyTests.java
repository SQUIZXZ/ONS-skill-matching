package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.SkillRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
@Transactional
public class SkillHierarchyTests {

    @Autowired
    SkillRepository skillRepository;

    @Test
    public void getsChildSkills () throws Exception{
        Skill parentSkill = skillRepository.findById(1L).get();


        assertEquals("language",parentSkill.getName());

        Skill childSkillOne = parentSkill.getChildSkills().get(0);
        Skill childSkillTwo = parentSkill.getChildSkills().get(1);

        assertEquals("java",childSkillOne.getName());
        assertEquals("python",childSkillTwo.getName());
    }

    @Test
    public void getsParentSkills() throws Exception{
        Skill childSkill = skillRepository.findById(2L).get();
        Skill parentSkill = childSkill.getParentSkills().get(0);

        assertEquals("language",parentSkill.getName());
    }
}
