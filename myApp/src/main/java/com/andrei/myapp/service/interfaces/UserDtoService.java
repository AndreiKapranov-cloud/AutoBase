package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.exceptions.EmailExistsException;
import com.andrei.myapp.exceptions.NameExistsException;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.UserEnum;

import java.util.List;

public interface UserDtoService {
    UserDto getUserByUsername(String userName);

    List<UserDto> getAll();

    UserDto getUserByLogin(String login);

    UserDto getUserByUserEmail(String userEmail);

    User save(RequestUserDto requestUserDto) throws EmailExistsException, NameExistsException;

    User saveWhenEdit(RequestUserDto requestUserDto);

    RequestUserDto getUserById(Long userId);

    List<UserDto> getUsersByRoleEquals(Role role);

    List<UserDto> getUsersByRoleRolEnum(RolEnum rolEnum);

    List<UserDto> getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThan(UserEnum userStatus, int carryingCapacity);

    List<UserDto> getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThanAndAuto_maxVolumeM3IsGreaterThan(UserEnum userStatus, int carryingCapacity, int volumeM3);

    List<UserDto> getUsersByAuto_CarryingCapacityIsGreaterThan(int carryingCapacity);

}
