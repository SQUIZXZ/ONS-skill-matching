package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.events.SkillRequestMade;
import com.nsa.ons.onsgroupproject.service.events.UserMade;

import java.util.Optional;

public interface UserRepository {

    public void saveUser(UserMade user);

}
