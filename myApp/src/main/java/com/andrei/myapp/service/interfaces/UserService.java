package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User save(User user);
    User getUserById(Long userId);
    List<User>getUsersByRoleEquals(Role role);
}
