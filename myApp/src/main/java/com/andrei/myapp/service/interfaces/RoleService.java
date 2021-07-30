package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.enums.RolEnum;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getRoleByRolEnumEquals(RolEnum rolEnum);
    Role getRoleByRoleId(Long roleId);
    Role save(Role role);
}
