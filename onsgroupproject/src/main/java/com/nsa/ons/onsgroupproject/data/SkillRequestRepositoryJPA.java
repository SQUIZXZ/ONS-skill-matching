package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRequestJPA extends JpaRepository<SkillRequest, Long> {

    Optional<SkillRequest> findByFurl(String furl);

}
