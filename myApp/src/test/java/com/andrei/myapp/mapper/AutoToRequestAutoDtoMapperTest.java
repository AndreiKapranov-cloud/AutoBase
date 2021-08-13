package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestAutoDto;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.service.interfaces.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoToRequestAutoDtoMapperTest {

    @Mock
    private UserService userService;

    private AutoToRequestAutoDtoMapper mapper;
    private final Long id = 1L;
    String userName = "Fedor";

    @Before
    public void init() {
        mapper = new AutoToRequestAutoDtoMapper(userService);
        User user = new User();
        user.setUserId(id);
        user.setUserName(userName);
        Mockito.when(userService.getUserById(id)).thenReturn(user);

        Mockito.when(userService.getUserByUsername(userName)).thenReturn(user);
    }


    @org.junit.Test
    public void givenRequestAutoDtoToAuto_whenMaps_thenCorrect() {
        RequestAutoDto requestAutoDto = new RequestAutoDto();
        requestAutoDto.setNumber("123");
        requestAutoDto.setCarryingCapacity(12);
        requestAutoDto.setMaxWeightWithCargoKg(1200);
        requestAutoDto.setMaxVolumeM3(4);
        requestAutoDto.setTechnicalInspection(true);
        requestAutoDto.setDriver("1");
        Auto auto = mapper.requestAutoDtoToAuto(requestAutoDto);
        System.out.println(requestAutoDto.getDriver());
        assertEquals(requestAutoDto.getNumber(), auto.getNumber());
        assertEquals(requestAutoDto.getCarryingCapacity(), auto.getCarryingCapacity());
        assertEquals(requestAutoDto.getMaxWeightWithCargoKg(), auto.getMaxWeightWithCargoKg());
        assertEquals(requestAutoDto.getMaxVolumeM3(), auto.getMaxVolumeM3());
        assertEquals(requestAutoDto.getTechnicalInspection(), auto.getTechnicalInspection());
        assertEquals(userService.getUserById(Long.valueOf(requestAutoDto.getDriver())), auto.getDriver());
    }
}
