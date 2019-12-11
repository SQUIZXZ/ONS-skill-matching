package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.data.UserRepositoryJPA;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.events.UserMade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProcessor implements UserCreator,UserFinder {

    private UserRepository userRepository;

    public UserProcessor(UserRepository repo) { userRepository = repo;
    }

    @Override
    public void makeUser(UserMade userMade) {
        userRepository.saveUser(userMade);
    }

    public Optional<User> findUserByUserName(String userName){
        return userRepository.findUserByUsername(userName);
    }
}



