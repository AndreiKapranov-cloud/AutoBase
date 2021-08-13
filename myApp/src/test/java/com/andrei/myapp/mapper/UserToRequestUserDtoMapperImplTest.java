package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.model.enums.UserEnumConverter;
import com.andrei.myapp.service.interfaces.AutoService;
import com.andrei.myapp.service.interfaces.RoleService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserToRequestUserDtoMapperImplTest {
    @Mock
    private RoleService roleService;
    @Mock
    private AutoService autoService;
    private UserToRequestUserDtoMapperImpl mapper;
    private UserEnumConverter userEnumConverter;
    private final Long roleId = 1L;
    private final RolEnum rolEnum = RolEnum.DRIVER;
    private final Long autoId = 2L;
    private final String number = "ddd";

    @Before
    public void init() {
        mapper = new UserToRequestUserDtoMapperImpl(roleService, autoService);
        Role role = new Role();
        Auto auto = new Auto();
        role.setRoleId(roleId);
        role.setRolEnum(rolEnum);
        auto.setAutoId(autoId);
        auto.setNumber(number);
        Mockito.when(autoService.getAutoByAutoId(autoId)).thenReturn(auto);
        Mockito.when(roleService.getRoleByRoleId(roleId)).thenReturn(role);
    }

    @org.junit.Test
    public void givenRequestUserDtoToUser_whenMaps_thenCorrect() {
        UserEnumConverter userEnumConverter = new UserEnumConverter();
        RequestUserDto requestUserDto = new RequestUserDto();
        requestUserDto.setUserId(1L);
        requestUserDto.setUserName("Uri");
        requestUserDto.setUserEmail("vggh@hjh");
        requestUserDto.setPassword("777");
        requestUserDto.setCreateDate("2021-11-11");
        requestUserDto.setSecondName("Smith");
        requestUserDto.setUserStatus("ill");
        requestUserDto.setRole("1");
        requestUserDto.setAuto("2");

        User user = mapper.RequestUserDtoToUser(requestUserDto);

        assertEquals(requestUserDto.getUserId(), user.getUserId());
        assertEquals(requestUserDto.getUserName(), user.getUserName());
        assertEquals(requestUserDto.getUserEmail(), user.getUserEmail());
        assertEquals(requestUserDto.getPassword(), user.getPassword());
        assertEquals(requestUserDto.getCreateDate(), String.valueOf(user.getCreateDate()));
        assertEquals(requestUserDto.getSecondName(), user.getSecondName());
        assertEquals(requestUserDto.getUserStatus(), userEnumConverter.convertToDatabaseColumn(user.getUserStatus()));
        assertEquals(roleService.getRoleByRoleId(Long.valueOf(requestUserDto.getRole())), user.getRole());
    }

    @org.junit.Test
    public void givenUserToRequestUserDto_whenMaps_thenCorrect() {
        UserEnumConverter userEnumConverter = new UserEnumConverter();
        User user = new User();
        user.setUserId(1L);
        user.setUserName("Uri");
        user.setUserEmail("vggh@hjh");
        user.setPassword("777");
        user.setCreateDate(Date.valueOf("2021-11-11"));
        user.setSecondName("Smith");
        user.setUserStatus(UserEnum.ILL);
        user.setRole(roleService.getRoleByRoleId(roleId));
        user.setAuto(autoService.getAutoByAutoId(autoId));

        RequestUserDto requestUserDto = mapper.userToRequestUserDto(user);

        assertEquals(user.getUserId(), requestUserDto.getUserId());
        assertEquals(user.getUserName(), requestUserDto.getUserName());
        assertEquals(user.getUserEmail(), requestUserDto.getUserEmail());
        assertEquals(user.getPassword(), requestUserDto.getPassword());
        assertEquals(user.getCreateDate(), Date.valueOf(requestUserDto.getCreateDate()));
        assertEquals(user.getSecondName(), requestUserDto.getSecondName());
        assertEquals(userEnumConverter.convertToDatabaseColumn(user.getUserStatus()), requestUserDto.getUserStatus());
        assertEquals(user.getRole(), roleService.getRoleByRoleId(Long.valueOf(requestUserDto.getRole())));
        assertEquals(user.getAuto(), autoService.getAutoByAutoId(Long.valueOf(requestUserDto.getAuto())));

    }
}