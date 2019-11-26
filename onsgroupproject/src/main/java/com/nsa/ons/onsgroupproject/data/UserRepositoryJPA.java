package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
