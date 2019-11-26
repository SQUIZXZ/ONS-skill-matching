package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.SkillRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepositoryJPA extends SkillRepository, JpaRepository<Skill, Long> {

    // JPA Query searching for Skills
    @Query(value = "select * from skill where upper(skill_name) like concat('%', upper(:paramSearch), '%')", nativeQuery = true)
    List<com.nsa.ons.onsgroupproject.domain.Skill> findBySearch(@Param("paramSearch") String searchTerm);

    @Query(value = "select id  from skill where skill_name =:paramSearch ", nativeQuery = true)
    int findByName(@Param("paramSearch") String paramSearch);



   /* @Query(value = "select first_name , email from users join user_skill on \n" +
            "    users.id = user_skill.user_id join skill on skill.id = \n" +
            "    user_skill.skill_id where skill.skill_name =paramSearch )", nativeQuery = true)
    List<com.nsa.ons.onsgroupproject.domain.UserInfo> findBySkill(@Param("paramSearch") String paramSearch);*/
}


