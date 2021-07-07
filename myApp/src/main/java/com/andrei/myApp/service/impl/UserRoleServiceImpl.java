package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.mapper.UserRoleUserRoleDtoMapper;
import com.andrei.myApp.model.dao.UserRoleDao;
import com.andrei.myApp.model.entity.UserRole;
import com.andrei.myApp.service.serviceInterfaces.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {


    private final UserRoleDao dao;
    private final UserRoleUserRoleDtoMapper mapper;

    public UserRoleServiceImpl(UserRoleDao dao, UserRoleUserRoleDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

   /* @Override
    public List<UserRole> getAll() {
        List<UserRole> userRoles = dao.findAll();
        return userRoles;
    }*/
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
    public UserRoleDto getUserRoleByRole(String role) {
      UserRole userRole = dao.getUserRoleByRole(role);
      UserRoleDto userRoleDto = mapper.userRoleToUserRoleDto(userRole);
        return userRoleDto;
    }
    @Override
    public UserRoleDto getUserRoleByRoleId(Long roleId) {
        UserRole userRole = dao.getUserRoleByRoleId(roleId);
        UserRoleDto userRoleDto = mapper.userRoleToUserRoleDto(userRole);
        return userRoleDto;
    }

}
