package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.*;

import com.andrei.myapp.exceptions.EmailExistsException;
import com.andrei.myapp.exceptions.NameExistsException;
import com.andrei.myapp.mapper.ToUserDtoMapper;
import com.andrei.myapp.mapper.UserToRequestUserDtoMapperImpl;
import com.andrei.myapp.model.dao.UserDao;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.service.interfaces.RoleDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;


@Service
@RequiredArgsConstructor
public class UserDtoServiceImpl implements UserDtoService {
  //  private final PasswordEncoder passwordEncoder;
    private final RoleDtoService roleDtoService;
    private final UserDao dao;
    private final ToUserDtoMapper mapper;
    private final UserToRequestUserDtoMapperImpl userToRequestUserDtoMapper;

    @Override
    public UserDto getUserByUsername(String userName) {
        User user = dao.getUserByUserName(userName);
        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto getUserByLogin(String login) {
        User user = dao.getUserByLogin(login);
        return mapper.userToUserDto(user);
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
    public UserDto getUserByUserEmail(String userEmail) {
        User user = dao.getUserByUserEmail(userEmail);
        return mapper.userToUserDto(user);
    }

    @Transactional
    public synchronized User saveWhenEdit(RequestUserDto requestUserDto) {
        User user = userToRequestUserDtoMapper.RequestUserDtoToUser(requestUserDto);
        return dao.save(user);
    }

    @Override
    @Transactional
    public User save(RequestUserDto requestUserDto) throws NameExistsException, EmailExistsException {
      /*  if (nameExists(requestUserDto.getUserName())) {
            throw new NameExistsException("There is an account with that name:"
                    + requestUserDto.getUserName());
        }
        if (emailExist(requestUserDto.getUserEmail())) {
            throw new EmailExistsException("There is an account with that email address:"
                    + requestUserDto.getUserEmail());
        }*/
       User user = userToRequestUserDtoMapper.RequestUserDtoToUser(requestUserDto);
        //   user.setPassword(passwordEncoder.encode(requestUserDto.getPassword()));
        return dao.save(user);
    }

    private boolean emailExist(String userEmail) {
        return dao.getUserByUserEmail(userEmail) != null;
    }

    private boolean nameExists(String userName) {
        return dao.getUserByUserName(userName) != null;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = dao.getUserByUserId(userId);
        return mapper.userToUserDto(user);
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
    public List<UserDto> getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThan(UserEnum userStatus,
                                                                                   int carryingCapacity) {
        List<User> users = dao.getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThan(UserEnum.READY,
                carryingCapacity);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public List<UserDto> getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThanAndAuto_maxVolumeM3IsGreaterThan
            (UserEnum userStatus, int carryingCapacity, int volumeM3) {
        List<User> users = dao.getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThanAndAuto_maxVolumeM3IsGreaterThan
                (UserEnum.READY, carryingCapacity, volumeM3);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;

    }


    @Override
    public List<UserDto> getUsersByAuto_CarryingCapacityIsGreaterThan(int carryingCapacity) {
        List<User> users = dao.getUsersByAuto_CarryingCapacityIsGreaterThan(carryingCapacity);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }
}






