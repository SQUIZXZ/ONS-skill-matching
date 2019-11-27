package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.UserSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSkillRepository extends CrudRepository<UserSkill, Integer> {
    @Query(value = "select *  from user_skill where skill_id =:paramSearch ", nativeQuery = true)
    List<UserSkill> findBySkill_Id(@Param("paramSearch") int paramSearch);


}
