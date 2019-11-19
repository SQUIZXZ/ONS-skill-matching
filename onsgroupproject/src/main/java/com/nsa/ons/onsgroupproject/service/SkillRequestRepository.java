package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;

import java.util.Optional;

public interface SkillRequestRepository {

    public Optional<SkillRequest> findByFurl(String furl);

    public void saveSkillRequest(SkillRequestMade skillRequest);

}
