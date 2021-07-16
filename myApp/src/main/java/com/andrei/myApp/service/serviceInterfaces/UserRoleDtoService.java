package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;

import java.util.List;

public interface UserRoleDtoService {
    List<UserRoleDto> getAll();
    UserRole save(UserRoleDto userRoleDto);
    UserRoleDto getUserRoleByUserId(Long userId);
    UserRoleDto getUserRoleByAutoTechnicalInspectionTrue();
}
