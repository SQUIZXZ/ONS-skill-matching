package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SkillRequestJPAAdaptor implements SkillRequestRepository {

     private SkillRequestJPA skillRequestJPA;

    public SkillRequestJPAAdaptor(SkillRequestJPA skillRequestJPARepo) {
        skillRequestJPA = skillRequestJPARepo;
    }

    @Override
    public Optional<SkillRequest> findByFurl(String furl) {
        return skillRequestJPA.findByFurl(furl);
    }

}
