package com.andrei.myapp.service.impl;

import com.andrei.myapp.model.dao.UserDao;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Override
    public User getUserByLogin(String login){
        return dao.getUserByLogin(login);
    }

    @Override
    public User getUserByUsername(String userName) {
        return dao.getUserByUserName(userName);
    }

    @Override
    public List<User> getAll() {
        return dao.findAll();
    }

    @Override
    public synchronized User save(User user) {
        return dao.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return dao.getUserByUserId(userId);
    }

    @Override
    public List<User> getUsersByRoleEquals(Role role) {
        return dao.getUsersByRoleEquals(role);
    }

    @Override
    public List<User> getUsersByAuto_CarryingCapacityIsGreaterThan(int carryingCapacity) {
        return dao.getUsersByAuto_CarryingCapacityIsGreaterThan(carryingCapacity);
    }

}
