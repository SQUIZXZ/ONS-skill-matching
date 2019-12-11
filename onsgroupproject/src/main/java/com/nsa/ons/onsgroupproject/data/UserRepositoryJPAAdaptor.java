package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.User;
import com.nsa.ons.onsgroupproject.service.UserRepository;
import com.nsa.ons.onsgroupproject.service.events.UserMade;
import com.nsa.ons.onsgroupproject.service.events.UserUpdated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class UserRepositoryJPAAdaptor implements UserRepository {

     private UserRepositoryJPA userRepositoryJPA;

    public UserRepositoryJPAAdaptor(UserRepositoryJPA userJPARepo) {
        userRepositoryJPA = userJPARepo;
    }

    @Override
    public void saveUser(UserMade userMade) {
        User newUser = new User(
                null,
                userMade.getUsername(),
                userMade.getEmail(),
                userMade.getPassword(),
                null
        );
        userRepositoryJPA.save(newUser);
    }

    public void updateUser(UserUpdated userUpdated){
        userUpdated.getThisUser().setUserSkills(userUpdated.getSkillsList());
        userRepositoryJPA.save(userUpdated.getThisUser());
    }

    public Optional<User> findUserByUsername(String userName){
        return Optional.of(userRepositoryJPA.findByUsername(userName));
    }

}
