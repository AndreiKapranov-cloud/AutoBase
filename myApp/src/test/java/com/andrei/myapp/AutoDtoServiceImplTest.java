package com.andrei.myapp;

import com.andrei.myapp.dto.AutoDto;
import com.andrei.myapp.model.dao.AutoDao;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.service.interfaces.AutoDtoService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoDtoServiceImplTest {
    @Autowired
    AutoDtoService autoDtoService;
    @MockBean
    AutoDao dao;
    private final Long id = 1L;
    private final Long audiId = 2L;
    String number = "SDRP";
    String audiNumber = "RPTS";
    int maxVolumeM3 = 3;
    int audiMaxVolume = 4;
    int randomVolume = 2;

    @Before
    public void setUp() {
        Auto auto = new Auto();
        Auto audi = new Auto();
        List<Auto> autos = new ArrayList<>();
        autos.add(auto);
        autos.add(audi);
        auto.setNumber(number);
        auto.setMaxVolumeM3(maxVolumeM3);
        audi.setNumber(audiNumber);
        audi.setMaxVolumeM3(audiMaxVolume);

        Mockito.when(dao.getAutoByAutoId(id)).thenReturn(auto);
        Mockito.when(dao.getAutoByNumber(number)).thenReturn(auto);
        Mockito.when(dao.getAutosByMaxVolumeM3After(randomVolume)).thenReturn(autos);
    }

    @org.junit.Test
    public void getAutosByMaxVolumeM3AfterTest() {
        List<AutoDto> autos = autoDtoService.getAutosByMaxVolumeM3After(randomVolume);
        Assertions.assertEquals(2, autos.size());
    }

    @org.junit.Test
    public void getAutoByIdTest() {
        AutoDto autoDto = autoDtoService.getAutoByAutoId(id);
        Assertions.assertNotEquals(null, autoDto);
    }

    @org.junit.Test
    public void getAutoByNumber() {
        AutoDto autoDto = autoDtoService.getAutoByNumber(number);
        Assertions.assertNotEquals(null, autoDto);
    }

}


