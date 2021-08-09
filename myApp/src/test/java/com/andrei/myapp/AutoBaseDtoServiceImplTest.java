package com.andrei.myapp;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.model.dao.AutoBaseDao;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoBaseDtoServiceImplTest {
    @MockBean
    private AutoBaseDtoService autoBaseDtoService;
    @MockBean
    private AutoBaseDao autoBaseDao;

    private AutoBaseDto autoBaseDto;
    @BeforeEach
    public void setUp(){
        autoBaseDto = new AutoBaseDto();
        autoBaseDto.setAddress("Puskina,12");
        autoBaseDto.setNameOfOrganization("Semiramida");
       @Test
               void findAutobase()
        AutoBaseDto getAutoBaseByNameOfOrganization(String nameOfOrganization);


        }
    }
}*/
