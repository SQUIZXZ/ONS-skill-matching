package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProcessor implements UserFinder {

    private UserRepository userRepository;

    public UserProcessor (UserRepository uRepo){
        userRepository = uRepo;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findBySkill(Long SkillId, Long UserId) {

        return userRepository.findBySkill(SkillId ,UserId);
    }
}
