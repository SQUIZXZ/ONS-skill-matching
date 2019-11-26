package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.events.UserMade;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> findByUsername(String username);

    public void saveUser(UserMade user);

}
