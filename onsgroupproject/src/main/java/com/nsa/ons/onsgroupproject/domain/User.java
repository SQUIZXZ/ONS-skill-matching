package com.nsa.ons.onsgroupproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(nullable = false, unique = true)
  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String email;

  @NotNull
  @NotEmpty
  private String password;

  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinTable(name = "user_skill",
  joinColumns = {@JoinColumn(name = "skill_id")},
  inverseJoinColumns = {@JoinColumn(name = "user_id")})
  List<Skill> userSkills;


//  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  @JoinColumn(name = "skill_id")
//  private UserSkill userSkill;

}