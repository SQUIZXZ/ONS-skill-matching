package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.service.events.UserMade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserProcessor implements UserCreator {

    private UserRepository userRepository;

    public UserProcessor(UserRepository aUserRepo){
        userRepository = aUserRepo;
    }

    @Override
    public void makeUser(UserMade userMade){
        userRepository.saveUser(userMade);
    }

}
