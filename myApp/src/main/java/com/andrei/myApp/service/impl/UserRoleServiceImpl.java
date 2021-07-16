package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.mapper.ToUserRoleDtoMapper;
import com.andrei.myApp.model.dao.UserRoleDao;
import com.andrei.myApp.model.entity.UserRole;
import com.andrei.myApp.service.serviceInterfaces.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDao dao;



    public UserRoleServiceImpl(UserRoleDao dao) {
        this.dao = dao;

    }

    @Override
    public List<UserRole> getAll() {
        List<UserRole> userRoles = dao.findAll();
        return userRoles;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return dao.save(userRole);
    }

    @Override
    public UserRole getUserRoleByUserId(Long userId) {
        UserRole userRole = dao.getUserRoleByUserId(userId);
        return userRole;

    }

    @Override
    public UserRole getUserRoleByAutoTechnicalInspectionTrue() {
        UserRole userRole = dao.getUserRoleByAutoTechnicalInspectionTrue();
        return userRole;
    }
}
