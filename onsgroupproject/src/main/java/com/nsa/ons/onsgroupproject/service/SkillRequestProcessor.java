package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SkillRequestProcessor implements SkillRequestCreator {

    private SkillRequestRepository skillRequestRepository;

    public SkillRequestProcessor(SkillRequestRepository aSkillRepo){
        skillRequestRepository = aSkillRepo;
    }

    @Override
    public void makeSkillRequest(SkillRequestMade skillRequestMade){
        skillRequestRepository.saveSkillRequest(skillRequestMade);
    }


}
