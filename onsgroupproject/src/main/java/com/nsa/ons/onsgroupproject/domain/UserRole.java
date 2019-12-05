package com.nsa.ons.onsgroupproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_role")
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_role_id")
  private Long userroleid;

  @Column(name = "userid")
  private Long userid;

  @Column(name = "role")
  private String role;

}
