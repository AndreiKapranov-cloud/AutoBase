package com.andrei.myapp;

import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.dao.UserDao;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.service.interfaces.UserDtoService;
import com.andrei.myapp.service.interfaces.UserService;
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
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @MockBean
    UserDao dao;
    private final Long id = 1L;
    String userName = "Ivan";

    @Before
    public void setUp() {
        User user = new User();
        user.setUserId(id);
        user.setUserName(userName);
        Mockito.when(dao.getUserByUserId(id)).thenReturn(user);
        Mockito.when(dao.getUserByUserName(userName)).thenReturn(user);
    }
    @org.junit.Test
    public void getUserByUserIdTest(){
        User user = userService.getUserById(id);
        Assertions.assertNotEquals(null,user);
    }
    @org.junit.Test
    public void getUserByUserNameTest(){
        User user = userService.getUserByUsername(userName);
        Assertions.assertNotEquals(null,user);
    }
}
