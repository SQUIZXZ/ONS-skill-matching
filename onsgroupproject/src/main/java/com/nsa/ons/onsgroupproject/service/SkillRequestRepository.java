package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;

import java.util.Optional;

public interface SkillRequestRepository {

    public Optional<SkillRequest> findByFurl(String furl);

}
