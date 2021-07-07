package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.*;

import com.andrei.myApp.mapper.UserRoleUserRoleDtoMapper;
import com.andrei.myApp.mapper.UserUserDtoMapper;
import com.andrei.myApp.model.dao.UserDao;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.service.serviceInterfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    private final UserUserDtoMapper mapper;


    public UserServiceImpl(UserDao dao, UserUserDtoMapper mapper, UserRoleUserRoleDtoMapper mapperR) {
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
    public User save( UserDto userDto) {

        User user = mapper.userDtoToUser(userDto);

        return dao.save(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = dao.getUserByUserId(userId);
        UserDto userDto = mapper.userToUserDto(user);
        return userDto;
    }
     /*@Override
  public User save( User user) {
    //  User user = mapper.userDtoToUser(userDto);
      return dao.save(user);}*/

}


