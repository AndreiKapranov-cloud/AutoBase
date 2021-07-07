package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.model.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    User save(UserDto userDto);
    UserDto getUserById(Long userId);
}
