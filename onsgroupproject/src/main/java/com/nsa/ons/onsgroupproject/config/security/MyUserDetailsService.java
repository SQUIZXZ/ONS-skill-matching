package com.nsa.ons.onsgroupproject.config.security;


import com.nsa.ons.onsgroupproject.data.UserRepositoryJPA;
import com.nsa.ons.onsgroupproject.data.UserRolesRepositoryJPA;
import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.web.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepositoryJPA userRepository;
  @Autowired
  private UserRolesRepositoryJPA userRolesRepository;
  @Autowired
  private PasswordEncoder encoder;

  @Override
  public UserDetails loadUserByUsername(String username) {

    System.out.println("password encoded = " + encoder.encode("password"));


    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    } else {
      System.out.println("User = " + user);

      List<String> userRoles = userRolesRepository.findRoleByUsername(username);
      return new MyUserPrincipal(user, userRoles);
    }
  }

  public User registerNewUserAccount(UserForm userForm) {

    User newUser = new User(null, userForm.getUsername(),userForm.getEmail(), userForm.getPassword());


    return newUser;

  }

}
