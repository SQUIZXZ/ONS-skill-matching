package com.nsa.ons.onsgroupproject.config.security;

import com.nsa.ons.onsgroupproject.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUserPrincipal implements UserDetails {
  private User user;
  private List<String> userRoles;


  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    String roles = "ROLE_USER";
//    String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
    return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  //

  public User getUser() {
    return user;
  }
}
