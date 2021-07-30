package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring",uses ={ToUserDtoMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ToRoleDtoMapper {
    @Mapping(target = "users", ignore = true)
    RoleDto roleToRoleDto(Role role);


    @Mappings({
            @Mapping(source = "rolEnum", target = "rolEnum"),
            @Mapping(target = "users", ignore = true)
    })
    Role roleDtoToRole(RoleDto roleDto);
}
