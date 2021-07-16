package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.mapper.ToUserDtoMapper;
import com.andrei.myApp.mapper.ToUserRoleDtoMapper;
import com.andrei.myApp.model.dao.UserRoleDao;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import com.andrei.myApp.service.serviceInterfaces.UserRoleDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleDtoServiceImpl implements UserRoleDtoService {

    private final UserRoleDao dao;
    private final ToUserRoleDtoMapper mapper;


    public UserRoleDtoServiceImpl(UserRoleDao dao, ToUserRoleDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<UserRoleDto> getAll() {
        List<UserRole> userRoles = dao.findAll();
        List<UserRoleDto> userRoleDtos = new ArrayList<>();
        userRoles.forEach(userRole -> {
            UserRoleDto userRoleDto = mapper.userRoleToUserRoleDto(userRole);
            userRoleDtos.add(userRoleDto);
        });
        return userRoleDtos;
    }

    @Override
    public UserRole save(UserRoleDto userRoleDto) {
        UserRole userRole = mapper.userRoleDtoToUserRole(userRoleDto);
        return dao.save(userRole);
    }

    @Override
    public UserRoleDto getUserRoleByUserId(Long userId) {
        UserRole userRole = dao.getUserRoleByUserId(userId);
        UserRoleDto userRoleDto = mapper.userRoleToUserRoleDto(userRole);
        return userRoleDto;

    }

    @Override
    public UserRoleDto getUserRoleByAutoTechnicalInspectionTrue() {
       UserRole userRole = dao.getUserRoleByAutoTechnicalInspectionTrue();
       UserRoleDto userRoleDto =mapper.userRoleToUserRoleDto(userRole);
       return userRoleDto;
    }
}
