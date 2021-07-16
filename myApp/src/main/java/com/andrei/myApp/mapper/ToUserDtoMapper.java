package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses={ToAutoBaseDtoMapper.class, ToRoleDtoMapper.class})
public interface ToUserDtoMapper {
    @Mapping(target = "roles", ignore = true)
    UserDto userToUserDto(User user);
    @Mapping(target = "roles", ignore = true)
    User userDtoToUser(UserDto userDto);
}
