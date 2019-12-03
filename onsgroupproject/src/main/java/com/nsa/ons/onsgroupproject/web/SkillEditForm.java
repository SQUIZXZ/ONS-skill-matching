package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillEditForm {
    @NotNull
    private Long id;

    @NotEmpty(message = "skillEditEmpty")
    @Size(max = 100, message = "skillNameTooLong")
    private String skillName;

    @Size(max = 200, message = "skillDescriptionTooLong")
    private String skillDescription;

    private List<String> parentSkills;

}
