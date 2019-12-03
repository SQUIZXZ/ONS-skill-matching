package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryJPAAdaptor implements UserRepository {

    private UserRepositoryJPA userRepositoryJPA;

    public UserRepositoryJPAAdaptor(UserRepositoryJPA userJPARepo) {
        userRepositoryJPA = userJPARepo;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositoryJPA.findById(id);
    }

    @Override
    public Optional<User> findBySkill(Long skillId, Long userId) {
        return userRepositoryJPA.findBySkill(skillId, userId);
    }
}
