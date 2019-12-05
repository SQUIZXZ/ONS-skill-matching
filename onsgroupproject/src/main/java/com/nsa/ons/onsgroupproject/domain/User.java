package com.nsa.ons.onsgroupproject.domain;

import com.sun.xml.bind.v2.model.core.ID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "email", nullable = false, unique = true)
    @NotNull
    @NotEmpty
    private String email;
    
    @NotNull
    @NotEmpty
    private String password;

    @Column(name = "surname")
    private String surname;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
    private UserSkill userSkill;


}


