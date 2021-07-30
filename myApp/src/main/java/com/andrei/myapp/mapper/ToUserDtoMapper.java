package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses={ToAutoBaseDtoMapper.class, ToRoleDtoMapper.class})
public interface ToUserDtoMapper {
    @Mapping(target = "dispatchersTrips", ignore = true)
    @Mapping(target = "driversTrips", ignore = true)
    @Mapping(target = "autos",ignore = true)
    UserDto userToUserDto(User user);
    @Mapping(target = "dispatchersTrips", ignore = true)
    @Mapping(target = "driversTrips", ignore = true)
    @Mapping(target = "autos",ignore = true)
    User userDtoToUser(UserDto userDto);
}
