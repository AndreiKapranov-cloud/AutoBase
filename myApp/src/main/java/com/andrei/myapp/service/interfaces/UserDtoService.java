package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.exceptions.EmailExistsException;
import com.andrei.myapp.exceptions.NameExistsException;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;

import java.util.List;

public interface UserDtoService {
    UserDto getUserByUsername(String userName);

    List<UserDto> getAll();

    UserDto getUserByUserEmail(String userEmail);

    User save(RequestUserDto requestUserDto) throws EmailExistsException, NameExistsException;

    User saveWhenEdit(RequestUserDto requestUserDto);

    UserDto getUserById(Long userId);

    List<UserDto> getUsersByRoleEquals(Role role);

    List<UserDto> getUsersByRoleRolEnum(RolEnum rolEnum);

    List<UserDto> getUsersByRoleRolEnumAndAutosEmpty(RolEnum rolEnum);

}
