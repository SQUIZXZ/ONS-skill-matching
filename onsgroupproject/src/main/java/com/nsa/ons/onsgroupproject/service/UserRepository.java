package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import com.nsa.ons.onsgroupproject.service.events.UserMade;

import java.util.Optional;

public interface UserRepository {

    public Optional<User>findUserByUsername(String userName);

    public void saveUser(UserMade user);

}
