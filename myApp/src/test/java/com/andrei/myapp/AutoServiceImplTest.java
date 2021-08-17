package com.andrei.myapp;

import com.andrei.myapp.model.dao.AutoBaseDao;
import com.andrei.myapp.model.dao.AutoDao;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.service.interfaces.AutoBaseService;
import com.andrei.myapp.service.interfaces.AutoService;
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
public class AutoServiceImplTest {
    @Autowired
    AutoService autoService;
    @MockBean
    AutoDao autoDao;
    private final Long id = 1L;
    String number = "sdbt";
    int maxVolumeM3 = 3;

    @Before
    public void setUp() {
        Auto auto = new Auto();
        auto.setNumber(number);
        auto.setMaxVolumeM3(maxVolumeM3);
        Mockito.when(autoDao.getAutoByNumber(number)).thenReturn(auto);
        Mockito.when(autoDao.getAutoByAutoId(id)).thenReturn(auto);
    }

    @org.junit.Test
    public void getAutoByNumberTest() {
        Auto auto = autoService.getAutoByNumber(number);
        Assertions.assertNotEquals(null, auto);
    }

    @org.junit.Test
    public void getAutoById() {
        Auto auto = autoService.getAutoByAutoId(id);
        Assertions.assertNotEquals(null, auto);
    }
}

