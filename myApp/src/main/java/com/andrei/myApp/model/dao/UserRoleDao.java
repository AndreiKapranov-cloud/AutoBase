package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole,Long> {
    UserRole getUserRoleByRole(String role);
    UserRole getUserRoleByRoleId(Long roleId);
}
