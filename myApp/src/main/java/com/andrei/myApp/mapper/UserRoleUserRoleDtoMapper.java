package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface UserRoleUserRoleDtoMapper {
    UserRoleDto userRoleToUserRoleDto(UserRole userRole);
    UserRole userRoleDtoToUserRole(UserRoleDto userRoleDto);

}
