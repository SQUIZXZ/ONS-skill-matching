package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.service.events.SkillUpdated;

public interface SkillUpdater {

    public void updateSkill(SkillUpdated skillUpdated);
}
