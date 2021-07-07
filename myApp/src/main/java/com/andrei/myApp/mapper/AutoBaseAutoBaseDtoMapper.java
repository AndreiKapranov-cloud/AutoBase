package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.model.entity.Auto;
import com.andrei.myApp.model.entity.AutoBase;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AutoBaseAutoBaseDtoMapper {

        AutoBaseDto autoBaseToAutoBaseDto(AutoBase autoBase);
        AutoBase autoBaseDtoToAutoBase(AutoBaseDto autoBaseDto);
    }

