package com.nsa.ons.onsgroupproject.service.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMade {

    private String username;
    private String email;
    private String password;
    private String passwordConfirm;

}