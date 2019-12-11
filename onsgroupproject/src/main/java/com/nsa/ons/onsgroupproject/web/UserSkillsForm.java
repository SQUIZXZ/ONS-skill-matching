package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSkillsForm {
    private List<String> skillNames;

    private List<String> skillLevels;

    private List<String> skillPrivacy;
}
