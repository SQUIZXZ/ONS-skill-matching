package com.nsa.ons.onsgroupproject.service.events;

import com.nsa.ons.onsgroupproject.domain.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillMade {
    private String skillName;
    private String skillDescription;
    private List<Skill> parentSkills;
}
