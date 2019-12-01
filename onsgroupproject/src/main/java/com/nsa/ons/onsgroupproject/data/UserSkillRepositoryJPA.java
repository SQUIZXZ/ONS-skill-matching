package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSkillRepositoryJPA extends JpaRepository<UserSkill , Long> {

    @Query(value = "select * from user_skill where skill_id = :paramSearch", nativeQuery = true)
   List<com.nsa.ons.onsgroupproject.domain.UserSkill> findUsersSkillBySkill(@Param("paramSearch") Long searchTerm);

    @Query(value = "select * from user_skill where privacy = false ", nativeQuery = true)
    UserSkill<com.nsa.ons.onsgroupproject.domain.UserSkill> findUserSkillByPrivace(@Param("paramSearch") Long searchTerm);


}
