package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SkillRepositoryJPA extends JpaRepository<Skill, Long> {

    // JPA Query searching for Skills
    @Query(value = "select * from skill where upper(skill_name) like concat('%', upper(:paramSearch), '%')", nativeQuery = true)
    List<Skill> findBySearch(@Param("paramSearch") String searchTerm);

    List<Skill> findAll();

    Optional<Skill> findByName(String name);

}


