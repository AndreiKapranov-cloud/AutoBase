package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String userName);
    List<User> getAll();
    User save(User user);
    User getUserById(Long userId);
    List<User>getUsersByRoleEquals(Role role);
    List<User> getUsersByAuto_CarryingCapacityIsGreaterThan(int carryingCapacity);
}
