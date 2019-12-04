package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SkillRequestProcessor implements SkillRequestCreator, SkillRequestFinder {

    private SkillRequestRepository skillRequestRepository;

    public SkillRequestProcessor(SkillRequestRepository aSkillRepo){
        skillRequestRepository = aSkillRepo;
    }

    @Override
    public void makeSkillRequest(SkillRequestMade skillRequestMade){
        skillRequestRepository.saveSkillRequest(skillRequestMade);
    }

    public Optional findSkillRequestByFurl(String furl){
        return skillRequestRepository.findByFurl(furl);
    }


}
