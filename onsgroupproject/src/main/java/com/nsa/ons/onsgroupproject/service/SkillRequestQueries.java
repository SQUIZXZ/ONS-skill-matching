package com.nsa.ons.onsgroupproject.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillRequestQueries implements SkillRequestFinder {
    SkillRequestRepository skillRequestRepository;

    public SkillRequestQueries(SkillRequestRepository srRepo){
        skillRequestRepository = srRepo;
    }

    public Optional findSkillRequestByFurl(String furl){
        return skillRequestRepository.findByFurl(furl);
    }
}
