package com.nsa.ons.onsgroupproject.service;


import com.nsa.ons.onsgroupproject.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Integer> {

}
