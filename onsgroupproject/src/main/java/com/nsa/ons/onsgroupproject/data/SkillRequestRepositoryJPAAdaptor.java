package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SkillRequestRepositoryJPAAdaptor implements SkillRequestRepository {

     private SkillRequestRepositoryJPA skillRequestRepositoryJPA;

    public SkillRequestRepositoryJPAAdaptor(SkillRequestRepositoryJPA skillRequestJPARepo) {
        skillRequestRepositoryJPA = skillRequestJPARepo;
    }

    @Override
    public Optional<SkillRequest> findByFurl(String furl) {
        return skillRequestRepositoryJPA.findByFurl(furl);
    }

    @Override
    public void saveSkillRequest(SkillRequest skillRequest) {

        skillRequestRepositoryJPA.save(skillRequest);

    }

}
