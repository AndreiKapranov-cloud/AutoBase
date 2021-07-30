package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.service.interfaces.RoleService;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UserToRequestUserDtoMapperImpl {
    private final RoleService roleService;

    public UserToRequestUserDtoMapperImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    public RequestUserDto userToRequestUserDto(User user) {
        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setUserId(user.getUserId());
        requestUserDto.setUserName(user.getUserName());
        requestUserDto.setUserEmail(user.getUserEmail());
        requestUserDto.setPassword(user.getPassword());
        requestUserDto.setCreateDate(String.valueOf(user.getCreateDate()));
        requestUserDto.setSecondName(user.getSecondName());
        requestUserDto.setReady(user.getReady());
        requestUserDto.setRole(String.valueOf(user.getRole()));
        return requestUserDto;
    }

    public User RequestUserDtoToUser(RequestUserDto requestUserDto) {
        User user = new User();
        user.setUserId(requestUserDto.getUserId());
        user.setUserName(requestUserDto.getUserName());
        user.setUserEmail(requestUserDto.getUserEmail());
        user.setPassword(requestUserDto.getPassword());
        user.setCreateDate(Date.valueOf(requestUserDto.getCreateDate()));
        user.setSecondName(requestUserDto.getSecondName());
        user.setReady(requestUserDto.getReady());
        user.setRole(roleService.getRoleByRoleId(Long.valueOf(requestUserDto.getRole())));
        return user;
    }
}
