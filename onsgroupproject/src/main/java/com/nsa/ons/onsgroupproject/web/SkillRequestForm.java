package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillRequestForm {

    @NotNull
    @Size(min = 2, max = 100, message = "Invalid Name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 100, message = "Invalid Surname")
    private String surname;

    @NotNull
    @Size(min = 2, max = 100, message = "Invalid department name")
    private String department;

    @NotNull
    @Size(min = 2, max = 100, message = "Skill not Found") //This will likely be a dropdown when we get the skill database up and running
    private String skill;

    @NotNull
    @Size(min = 2, max = 300, message = "Your Description is too long")
    private String taskDescription;

}
