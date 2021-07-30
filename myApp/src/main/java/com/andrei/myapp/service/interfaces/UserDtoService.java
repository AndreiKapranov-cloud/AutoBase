package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;

import java.util.List;

public interface UserDtoService {
    List<UserDto> getAll();
    User save(RequestUserDto requestUserDto);
    UserDto getUserById(Long userId);
    List<UserDto>getUsersByRoleEquals(Role role);
    List<UserDto>getUsersByRoleRolEnum(RolEnum rolEnum);
    List<UserDto>getUsersByRoleRolEnumAndAutosEmpty(RolEnum rolEnum);

}
