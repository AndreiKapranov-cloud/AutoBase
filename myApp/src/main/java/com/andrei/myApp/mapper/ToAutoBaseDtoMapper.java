package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.model.entity.AutoBase;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToAutoBaseDtoMapper {
    @Mapping(target = "trips", ignore = true)
    AutoBaseDto autoBaseToAutoBaseDto(AutoBase autoBase);
    @Mapping(target = "trips", ignore = true)
    AutoBase autoBaseDtoToAutoBase(AutoBaseDto autoBaseDto);
}
