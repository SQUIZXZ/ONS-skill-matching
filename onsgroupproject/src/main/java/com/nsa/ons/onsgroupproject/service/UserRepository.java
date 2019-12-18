package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import com.nsa.ons.onsgroupproject.service.events.UserMade;
import com.nsa.ons.onsgroupproject.service.events.UserUpdated;

import java.util.Optional;

public interface UserRepository {

    public Optional<User>findUserByUsername(String userName);

    public void saveUser(UserMade user);

    public void updateUser(UserUpdated userUpdated);

    public Optional<User>findUserById(Long Id);

}
