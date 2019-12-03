package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<User,Long> {

    public Optional<User> findById(Long id);

    @Query(value = "select * from user_skill where skill_id =SkillId AND User_Id =UserId", nativeQuery = true)
    Optional<User> findBySkill ( Long SkillId , Long UserId);
}
