package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillRequestForm {

    @NotNull
    @Size(min = 2, max = 100, message = "firstName")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 100, message = "surname")
    private String surname;

    @NotNull
    @Size(min = 2, max = 100, message = "department")
    private String department;

    @NotNull
    @Size(min = 2, max = 100, message = "skill") //This will likely be a dropdown when we get the skill database up and running
    private String skill;

    @NotNull
    @Size(min = 2, max = 300, message = "taskDescription")
    private String taskDescription;

    @NotEmpty(message = "furlEmpty")
    @Size(max = 20, message = "furlToLong")
    @Pattern(regexp = "^\\w+$|", message = "furlBadChar")
    private String furl;

}
