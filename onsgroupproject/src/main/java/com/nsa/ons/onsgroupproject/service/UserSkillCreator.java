package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.service.events.UserSkillMade;

public interface UserSkillCreator {
    public void saveUserSkill(UserSkillMade userSkillMade);
}
