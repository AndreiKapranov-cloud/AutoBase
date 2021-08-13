package com.andrei.myapp;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.model.dao.AutoBaseDao;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoBaseDtoServiceImplTest {
    @Autowired
    AutoBaseDtoService autoBaseDtoService;
    @MockBean
    AutoBaseDao autoBaseDao;
    private final Long id = 1L;
    String nameOfOrganization = "Semiramida";
    String address = "Piushkina,12";


    @Before
    public void setUp() {
        AutoBase autoBase = new AutoBase();
        autoBase.setAddress(address);
        autoBase.setNameOfOrganization(nameOfOrganization);
        Mockito.when(autoBaseDao.getAutoBaseByAutoBaseId(id)).thenReturn(autoBase);
        Mockito.when(autoBaseDao.getAutoBaseByNameOfOrganization(nameOfOrganization)).thenReturn(autoBase);
    }

    @org.junit.Test
    public void getAutoBaseByIdTest() {
AutoBaseDto autoBaseDto=autoBaseDtoService.getAutoBaseByAutoBaseId(id);
        Assertions.assertNotEquals(null,autoBaseDto);
    }
    @org.junit.Test
    public void getAutoBaseByAddressOfOrganizationTest() {
        AutoBaseDto autoBaseDto=autoBaseDtoService.getAutoBaseByNameOfOrganization(nameOfOrganization);
        Assertions.assertNotEquals(null,autoBaseDto);
    }

}

