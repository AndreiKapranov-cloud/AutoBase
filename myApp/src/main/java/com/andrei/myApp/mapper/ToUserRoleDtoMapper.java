package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.TripDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.Trip;
import com.andrei.myApp.model.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses={ToUserDtoMapper.class})
public interface ToUserRoleDtoMapper {
    @Mapping(target = "trips", ignore = true)
    UserRoleDto userRoleToUserRoleDto(UserRole userRole);
    @Mapping(target = "trips", ignore = true)
    UserRole userRoleDtoToUserRole(UserRoleDto userRoleDto);
}
