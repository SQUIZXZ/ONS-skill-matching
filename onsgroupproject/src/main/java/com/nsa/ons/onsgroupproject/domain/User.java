package com.nsa.ons.onsgroupproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
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

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "skill_id")
//    private UserSkill userSkill;
=======
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String password;
>>>>>>> eb285079c21d52c4fe6a4a3085ead38ddd87d316


<<<<<<< HEAD
}
=======
>>>>>>> eb285079c21d52c4fe6a4a3085ead38ddd87d316
