package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.RoleDto;
import com.andrei.myApp.model.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getRoleByRole(String role);
    Role getRoleByRoleId(Long roleId);
    Role save(Role role);
}
