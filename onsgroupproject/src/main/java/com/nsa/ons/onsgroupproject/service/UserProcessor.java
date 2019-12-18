package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.data.UserRepositoryJPA;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.events.UserMade;
import com.nsa.ons.onsgroupproject.service.events.UserUpdated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserProcessor implements UserCreator,UserFinder, UserUpdater {

    private UserRepository userRepository;

    public UserProcessor(UserRepository repo) { userRepository = repo;
    }

    @Override
    public void makeUser(UserMade userMade) {
        userRepository.saveUser(userMade);
    }

    public void updateUser(UserUpdated userUpdated){
        log.debug("################# got to processor level ######################");
        userRepository.updateUser(userUpdated);
    }

    public Optional<User> findUserByUserName(String userName){
        return userRepository.findUserByUsername(userName);
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findUserById(id);
    }
}



