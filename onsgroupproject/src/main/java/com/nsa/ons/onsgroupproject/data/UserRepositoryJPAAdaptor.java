package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.UserRepository;
import com.nsa.ons.onsgroupproject.service.events.UserMade;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryJPAAdaptor implements UserRepository {

    private UserRepositoryJPA userRepositoryJPA;

    public UserRepositoryJPAAdaptor(UserRepositoryJPA userJPARepo) {
        userRepositoryJPA = userJPARepo;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepositoryJPA.findByUsername(username);
    }

    @Override
    public void saveUser(UserMade user) {
        User newUser = new User(
                null,
                user.getUsername(),
                user.getPassword(),
                user.getPasswordConfirm()
        );
        userRepositoryJPA.save(newUser);
    }

}
