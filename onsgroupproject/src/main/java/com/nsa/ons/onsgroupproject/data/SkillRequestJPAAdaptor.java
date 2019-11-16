package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRequestJPAAdaptor implements SkillRequestRepository {

     private SkillRequestJPA skillRequestJPA;

    public SkillRequestJPAAdaptor(SkillRequestJPA skillRequestJPA) {
        this.skillRequestJPA = skillRequestJPA;
    }

}
