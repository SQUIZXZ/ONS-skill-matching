package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
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
    public void saveSkillRequest(SkillRequestMade skillRequest) {
        SkillRequest newSkillRequest = new SkillRequest(
                null,
                skillRequest.getFirstName(),
                skillRequest.getLastName(),
                skillRequest.getDepartment(),
                skillRequest.getSkill(),
                skillRequest.getDescription(),
                skillRequest.getFurl()
        );
        skillRequestRepositoryJPA.save(newSkillRequest);
    }

}
