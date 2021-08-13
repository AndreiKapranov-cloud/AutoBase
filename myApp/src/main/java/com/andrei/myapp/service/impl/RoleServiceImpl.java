package com.andrei.myapp.service.impl;

import com.andrei.myapp.model.dao.RoleDao;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.RoleService;
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
        return dao.findAll();
    }

    @Override
    public Role getRoleByRolEnumEquals(RolEnum rolEnum) {
        return dao.getRoleByRolEnumEquals(rolEnum);
    }

    @Override
    public Role getRoleByRoleId(Long roleId) {
        return dao.getRoleByRoleId(roleId);
    }

    @Override
    public synchronized Role save(Role role) {
        return dao.save(role);
    }
}

