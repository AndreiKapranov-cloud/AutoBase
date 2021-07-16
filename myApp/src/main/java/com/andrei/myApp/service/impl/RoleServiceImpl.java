package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.RoleDto;
import com.andrei.myApp.mapper.ToRoleDtoMapper;
import com.andrei.myApp.model.dao.RoleDao;
import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.service.serviceInterfaces.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleDao dao;


    public RoleServiceImpl(RoleDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = dao.findAll();
        return roles;
    }

    @Override
    public Role getRoleByRole(String role) {
        Role rolle = dao.getRoleByRole(role);
        return rolle;
    }
    @Override
    public Role getRoleByRoleId(Long roleId) {
        Role role = dao.getRoleByRoleId(roleId);
        return role;
    }
    @Override
    public Role save(Role role) {
        return dao.save(role);
    }
}

