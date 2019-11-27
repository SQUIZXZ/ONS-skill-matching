package com.nsa.ons.onsgroupproject.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @NotNull
    @NotEmpty
    private String username;

    @Column(name = "email")
    @NotNull
    @NotEmpty
    private String email;

    @Column(name = "password")
    @NotNull
    @NotEmpty
    private String password;

    @Column(name = "passwordConfirm")
    @NotNull
    @NotEmpty
    private String passwordConfirm;

}
