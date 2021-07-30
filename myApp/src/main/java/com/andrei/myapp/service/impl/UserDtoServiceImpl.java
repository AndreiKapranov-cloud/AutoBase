package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.*;

import com.andrei.myapp.mapper.ToUserDtoMapper;
import com.andrei.myapp.mapper.UserToRequestUserDtoMapperImpl;
import com.andrei.myapp.model.dao.UserDao;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.RoleDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDtoServiceImpl implements UserDtoService {
    private final RoleDtoService roleDtoService;
    private final UserDao dao;
    private final ToUserDtoMapper mapper;
    private final UserToRequestUserDtoMapperImpl userToRequestUserDtoMapper;

    public UserDtoServiceImpl(RoleDtoService roleDtoService, UserDao dao, ToUserDtoMapper mapper, UserToRequestUserDtoMapperImpl userToRequestUserDtoMapper) {
        this.roleDtoService = roleDtoService;
        this.dao = dao;
        this.mapper = mapper;
        this.userToRequestUserDtoMapper = userToRequestUserDtoMapper;
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
    @Transactional
    public User save(RequestUserDto requestUserDto) {
        User user = userToRequestUserDtoMapper.RequestUserDtoToUser(requestUserDto);
        return dao.save(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = dao.getUserByUserId(userId);
        UserDto userDto = mapper.userToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getUsersByRoleEquals(Role role) {
        List<User> users = dao.getUsersByRoleEquals(role);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public List<UserDto> getUsersByRoleRolEnum(RolEnum rolEnum) {
        List<User> users = dao.getUsersByRoleRolEnum(rolEnum);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public List<UserDto> getUsersByRoleRolEnumAndAutosEmpty(RolEnum rolEnum){
        List<User> users = dao.getUsersByRoleRolEnumAndAutosEmpty(rolEnum);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }


}




