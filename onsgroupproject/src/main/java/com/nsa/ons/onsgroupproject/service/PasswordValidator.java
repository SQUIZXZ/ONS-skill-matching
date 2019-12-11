package com.nsa.ons.onsgroupproject.service;

import com.nsa.ons.onsgroupproject.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator{

    @Override
    public boolean supports(Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
                "required.confirmPassword", "Field name is required.");

//        User user = (User)target;

//        if(!(user.getPassword().equals(user.()))){
//            errors.rejectValue("password", "notmatch.password");
//        }

    }

}