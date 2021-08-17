package com.andrei.myapp;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.model.dao.AutoBaseDao;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import com.andrei.myapp.service.interfaces.AutoBaseService;
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
public class AutoBaseServiceImplTest {
    @Autowired
    AutoBaseService autoBaseService;
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
        AutoBase autoBase=autoBaseService.getAutoBaseByAutoBaseId(id);
        Assertions.assertNotEquals(null,autoBase);
    }
    @org.junit.Test
    public void getAutoBaseByAddressOfOrganizationTest() {
        AutoBase autoBase=autoBaseService.getAutoBaseByNameOfOrganization(nameOfOrganization);
        Assertions.assertNotEquals(null,autoBase);
    }

}


