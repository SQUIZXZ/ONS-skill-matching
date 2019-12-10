package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.service.UserCreator;
import com.nsa.ons.onsgroupproject.service.events.UserMade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import javax.validation.Valid;
@Controller
@Slf4j
public class RegistrationController {
    private UserCreator userCreator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserCreator userCreator, PasswordEncoder passwordEncoder) {
        this.userCreator = userCreator;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(path = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("creating user has errors");
            String messages = "";
            for(ObjectError error : bindingResult.getAllErrors()) {
                messages += error.getDefaultMessage() + ", ";
            }
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messages.substring(0, messages.length() - 2));
        }
        String hash = passwordEncoder.encode(userForm.getPassword());
        UserMade registerUser = new UserMade(userForm.getUsername(), userForm.getEmail(), hash);
        userCreator.makeUser(registerUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");

    }
}
