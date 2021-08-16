package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.mapper.ToRoleDtoMapper;
import com.andrei.myapp.model.dao.RoleDao;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.RoleDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleDtoServiceImpl implements RoleDtoService {


    private final RoleDao dao;
    private final ToRoleDtoMapper mapper;

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
    public RoleDto getRoleByRolEnumEquals(RolEnum rolEnum) {
        Role roly = dao.getRoleByRolEnumEquals(rolEnum);
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
    @Transactional
    public synchronized Role save(RoleDto roleDto) {
        Role role =mapper.roleDtoToRole(roleDto);
        return dao.save(role);
    }
}
