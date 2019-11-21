package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;

public interface SkillRequestCreator {

    public void makeSkillRequest(SkillRequestMade skillRequestMade);

}
