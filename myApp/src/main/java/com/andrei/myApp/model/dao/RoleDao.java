package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
    Role getRoleByRole(String role);
    Role getRoleByRoleId(Long roleId);
}
