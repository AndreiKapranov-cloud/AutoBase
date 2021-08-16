package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.UserEnumConverter;
import com.andrei.myapp.service.interfaces.AutoService;
import com.andrei.myapp.service.interfaces.RoleService;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UserToRequestUserDtoMapperImpl {
    private final RoleService roleService;
    private final AutoService autoService;
    UserEnumConverter userEnumConverter = new UserEnumConverter();
    public UserToRequestUserDtoMapperImpl(RoleService roleService, AutoService autoService) {
        this.roleService = roleService;
        this.autoService = autoService;
    }

    public RequestUserDto userToRequestUserDto(User user) {
        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setUserId(user.getUserId());
        requestUserDto.setUserName(user.getUserName());
        requestUserDto.setUserEmail(user.getUserEmail());
        requestUserDto.setPassword(user.getPassword());
        requestUserDto.setCreateDate(String.valueOf(user.getCreateDate()));
        requestUserDto.setSecondName(user.getSecondName());
        requestUserDto.setLogin(user.getLogin());
        requestUserDto.setUserStatus(userEnumConverter.convertToDatabaseColumn(user.getUserStatus()));
        requestUserDto.setRole(String.valueOf((user.getRole()).getRoleId()));
        requestUserDto.setAuto(String.valueOf((user.getAuto()).getAutoId()));
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
        user.setLogin(requestUserDto.getLogin());
        user.setUserStatus(userEnumConverter.convertToEntityAttribute(requestUserDto.getUserStatus()));
        user.setRole(roleService.getRoleByRoleId(Long.valueOf(requestUserDto.getRole())));
        user.setAuto(autoService.getAutoByAutoId(Long.valueOf(requestUserDto.getAuto())));
        return user;
    }
}
