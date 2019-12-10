package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;

import java.util.List;
import java.util.Optional;

public interface SkillRequestFinder {
    public Optional findSkillRequestByFurl(String furl);

    public List<SkillRequest> findAll();

}
