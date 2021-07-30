package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.enums.RolEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
    Role getRoleByRolEnumEquals(RolEnum rolEnum);
    Role getRoleByRoleId(Long roleId);
}
