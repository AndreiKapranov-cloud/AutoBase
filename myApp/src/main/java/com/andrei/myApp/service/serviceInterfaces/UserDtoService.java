package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;

import java.util.List;

public interface UserDtoService {
    List<UserDto> getAll();
    User save(UserDto userDto);
    UserDto getUserById(Long userId);

}
