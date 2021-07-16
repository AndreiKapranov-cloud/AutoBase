package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.mapper.ToUserDtoMapper;
import com.andrei.myApp.model.dao.UserDao;
import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import com.andrei.myApp.service.serviceInterfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;



    public UserServiceImpl(UserDao dao) {
        this.dao = dao;


    }
    @Override
    public List<User> getAll() {
        List<User> users = dao.findAll();
        return users;
    }
    @Override
    public User save(User user) {
        return dao.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        User user = dao.getUserByUserId(userId);
        return user;
    }

}
