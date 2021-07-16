package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.*;

import com.andrei.myApp.mapper.ToUserDtoMapper;
import com.andrei.myApp.model.dao.UserDao;
import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import com.andrei.myApp.service.serviceInterfaces.UserDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDtoServiceImpl implements UserDtoService {

    private final UserDao dao;
    private final ToUserDtoMapper mapper;


    public UserDtoServiceImpl(UserDao dao, ToUserDtoMapper mapper) {
        this.dao = dao;

        this.mapper = mapper;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = dao.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public User save(UserDto userDto) {

        User user = mapper.userDtoToUser(userDto);

        return dao.save(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = dao.getUserByUserId(userId);
        UserDto userDto = mapper.userToUserDto(user);
        return userDto;
    }

}




