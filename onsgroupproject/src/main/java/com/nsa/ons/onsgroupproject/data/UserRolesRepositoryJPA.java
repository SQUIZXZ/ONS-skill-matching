package com.nsa.ons.onsgroupproject.data;

import com.nsa.ons.onsgroupproject.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRolesRepositoryJPA extends JpaRepository<UserRole, Long> {

  @Query("select a.role from UserRole a, User b where b.username=?1 and a.userid=b.id")
  public List<String> findRoleByUsername(String username);

}
