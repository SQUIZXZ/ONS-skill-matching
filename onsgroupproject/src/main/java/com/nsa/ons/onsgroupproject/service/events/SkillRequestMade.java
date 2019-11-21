package com.nsa.ons.onsgroupproject.service.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillRequestMade {
    private String firstName;
    private String lastName;
    private String department;
    private String skill;
    private String description;
    private String furl;

}
