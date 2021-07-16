package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.OrdersDto;
import com.andrei.myApp.dto.RoleDto;
import com.andrei.myApp.mapper.ToRoleDtoMapper;
import com.andrei.myApp.model.dao.RoleDao;
import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.service.serviceInterfaces.RoleDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleDtoServiceImpl implements RoleDtoService {


    private final RoleDao dao;
    private final ToRoleDtoMapper mapper;

    public RoleDtoServiceImpl(RoleDao dao, ToRoleDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

   /* @Override
    public List<UserRole> getAll() {
        List<UserRole> userRoles = dao.findAll();
        return userRoles;
    }*/
  @Override
    public List<RoleDto> getAll() {
        List<Role> roles = dao.findAll();
      List<RoleDto> roleDtos = new ArrayList<>();
      roles.forEach(role -> {
          RoleDto roleDto = mapper.roleToRoleDto(role);
          roleDtos.add(roleDto);
      });
        return roleDtos;
    }

    @Override
    public RoleDto getRoleByRole(String role) {
      Role roly = dao.getRoleByRole(role);
      RoleDto roleDto = mapper.roleToRoleDto(roly);
        return roleDto;
    }
    @Override
    public RoleDto getRoleByRoleId(Long roleId) {
        Role role = dao.getRoleByRoleId(roleId);
        RoleDto roleDto = mapper.roleToRoleDto(role);
        return roleDto;
    }
    @Override
    public Role save(RoleDto roleDto) {
        Role role =mapper.roleDtoToRole(roleDto);
        return dao.save(role);
    }
}
