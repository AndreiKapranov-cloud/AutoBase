package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.RoleDto;
import com.andrei.myApp.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses ={ToUserDtoMapper.class})
public interface ToRoleDtoMapper {
    @Mapping(target = "users", ignore = true)
    RoleDto roleToRoleDto(Role role);

    @Mapping(target = "users", ignore = true)
    Role roleDtoToRole(RoleDto roleDto);
}
