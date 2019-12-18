package com.nsa.ons.onsgroupproject.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserForm {

  @NotEmpty
  @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "email")
  private String email;

  @NotEmpty
  @Size(min = 2, max = 100, message = "username")
  private String username;

  @NotEmpty
  @Size(min = 6, max = 100, message = "password")
  private String password;

  @NotEmpty
  @Size(min = 6, max = 100, message = "confirmPassword")
  private String confirmPassword;
}
