package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.RoleDto;
import com.andrei.myApp.model.entity.Role;

import java.util.List;

public interface RoleDtoService {
   List<RoleDto> getAll();
   RoleDto getRoleByRole(String role);
   RoleDto getRoleByRoleId(Long roleId);
   Role save(RoleDto roleDto);
}
