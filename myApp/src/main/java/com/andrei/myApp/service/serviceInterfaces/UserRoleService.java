package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.UserRole;

import java.util.List;

public interface UserRoleService {
   List<UserRoleDto> getAll();
   UserRoleDto getUserRoleByRole(String role);
   UserRoleDto getUserRoleByRoleId(Long roleId);
}
