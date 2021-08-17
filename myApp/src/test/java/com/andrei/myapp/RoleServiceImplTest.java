package com.andrei.myapp;

import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.model.dao.RoleDao;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.RoleService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {
    @Autowired
    RoleService roleService;
    @MockBean
    RoleDao dao;
    private final Long id = 1L;
    RolEnum rolEnum = RolEnum.DISPATCHER;

    @Before
    public void setUp() {
        Role role = new Role();
        role.setRoleId(id);
        role.setRolEnum(rolEnum);
        Mockito.when(dao.getRoleByRoleId(id)).thenReturn(role);
        Mockito.when(dao.getRoleByRolEnumEquals(rolEnum)).thenReturn(role);
    }

    @org.junit.Test
    public void getRoleByRoleIdTest() {
        Role role = roleService.getRoleByRoleId(id);
        Assertions.assertNotEquals(null, role);
    }
    @org.junit.Test
    public void getRoleByRolEnumEquals(){
        Role role = roleService.getRoleByRolEnumEquals(rolEnum);
        Assertions.assertNotEquals(null,role);
    }



}
