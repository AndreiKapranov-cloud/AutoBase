package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAll();
    UserRole save(UserRole userRole);
    UserRole getUserRoleByUserId(Long userId);
    UserRole getUserRoleByAutoTechnicalInspectionTrue();
}
