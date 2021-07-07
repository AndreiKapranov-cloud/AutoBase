package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.Auto;
import com.andrei.myApp.model.entity.AutoBase;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring"/*,uses={UserRoleUserRoleDtoMapper.class,AutoBaseAutoBaseDtoMapper.class}*/)
public interface UserUserDtoMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

  /* UserRoleDto userRoleToUserRoleDto(UserRole userRole);

    UserRole userRoleDtoToUserRole(UserRoleDto userRoleDto);

    AutoBaseDto autoBaseToAutoBaseDto(AutoBase autoBase);

    AutoBase autoBaseDtoToAutoBase(AutoBaseDto autoBaseDto);

*/
    }

