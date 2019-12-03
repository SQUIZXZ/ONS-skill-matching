package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillEditForm {
    @NotNull
    @Size(max = 100, message = "skillNameTooLong")
    private String SkillName;

    @NotNull
    @Size(max = 200, message = "skillDescriptionTooLong")
    private String SkillDescription;

    private List<String> parentSkills;

}
