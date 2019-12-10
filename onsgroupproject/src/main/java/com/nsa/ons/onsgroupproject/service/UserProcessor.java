package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.data.UserRepositoryJPA;
import com.nsa.ons.onsgroupproject.service.events.UserMade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserProcessor implements UserCreator {

    private UserRepository userRepository;

    public UserProcessor(UserRepository repo) { userRepository = repo;
    }

    @Override
    public void makeUser(UserMade userMade) {
        userRepository.saveUser(userMade);
    }
}



