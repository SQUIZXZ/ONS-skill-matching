package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillCreationForm {
    @NotEmpty(message = "skillEmpty")
    @Size(max = 100, message = "skillSize")
    private String skill;

    private String parent;
}
