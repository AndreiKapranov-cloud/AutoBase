package com.andrei.myapp;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.mapper.ToAutoBaseDtoMapper;
import com.andrei.myapp.model.entity.AutoBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToAutoBaseDtoMapperTest {

    private final ToAutoBaseDtoMapper mapper
            = Mappers.getMapper(ToAutoBaseDtoMapper.class);

    @org.junit.Test
    public void givenToAutoBaseDto_whenMaps_thenCorrect() {
        AutoBase autoBase = new AutoBase();
        autoBase.setAddress("Pushkina,25");
        autoBase.setNameOfOrganization("Semiramida");
        AutoBaseDto autoBaseDto = mapper.autoBaseToAutoBaseDto(autoBase);
        assertEquals(autoBase.getAddress(), autoBaseDto.getAddress());
        assertEquals(autoBase.getNameOfOrganization(), autoBaseDto.getNameOfOrganization());

    }

    @Test
    public void givenToAutoBase_whenMaps_thenCorrect() {
        AutoBaseDto autoBaseDto = new AutoBaseDto();
        autoBaseDto.setAddress("Pushkina,25");
        autoBaseDto.setNameOfOrganization("Semiramida");
        AutoBase autoBase = mapper.autoBaseDtoToAutoBase(autoBaseDto);
        assertEquals(autoBaseDto.getAddress(), autoBase.getAddress());
        assertEquals(autoBaseDto.getNameOfOrganization(), autoBase.getNameOfOrganization());

    }
}

