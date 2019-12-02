package com.nsa.ons.onsgroupproject.service;


import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository{
    public Optional<User> findUserById(Long id);

}
