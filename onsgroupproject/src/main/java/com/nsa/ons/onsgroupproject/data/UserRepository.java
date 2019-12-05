package com.nsa.ons.onsgroupproject.data;


import com.nsa.ons.onsgroupproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
