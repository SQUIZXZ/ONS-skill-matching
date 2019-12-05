package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserForm {

  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String password;

  @NotNull
  @NotEmpty
  private String matchingPassword;


}
