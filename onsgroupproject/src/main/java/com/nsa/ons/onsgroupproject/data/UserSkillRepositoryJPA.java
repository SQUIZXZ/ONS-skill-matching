package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nsa.ons.onsgroupproject.service.UserSkillRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface UserSkillRepositoryJPA extends JpaRepository<UserSkill,Long> {

    @Query(value = "select * from user_skill where skill_id = :paramSearch", nativeQuery = true)
    List <com.nsa.ons.onsgroupproject.domain.UserSkill> findUsersSkillBySkillId ( long searchTerm);

    @Query(value = "select * from user_skill where privacy = false ", nativeQuery = true)
    Optional<UserSkill> findUserSkillByPrivacy( long searchTerm);

    public Optional<UserSkill> findById(Long id ,Long SkillId);





}
