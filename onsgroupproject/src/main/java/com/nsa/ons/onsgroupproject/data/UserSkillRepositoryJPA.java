package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserSkillRepositoryJPA extends JpaRepository<UserSkill, Long> {

    //    @Query("SELECT u FROM User u, UserSkill u_s WHERE u_s.skill_id = :searchTerm AND u.id = u_s.user_id")
//    List <User> findUsersSkillBySkillId(@Param("searchTerm") Long searchTerm);
    @Query(value = "select * from user_skill where user_id like :id", nativeQuery = true)
    List<UserSkill> findAllByUser_id(@Param("id")Long id);

    @Query(value = "select * from user_skill where skill_id like :id", nativeQuery = true)
    List<UserSkill> findBySkill_id(@Param("id")Long id);

}
