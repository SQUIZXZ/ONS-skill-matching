package com.nsa.ons.onsgroupproject.service.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSkillMade {
    private Long userID;
    private Long skillId;
    private Long level;
    private Boolean privacy ;
}
