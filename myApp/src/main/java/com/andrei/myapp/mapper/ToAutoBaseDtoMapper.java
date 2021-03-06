package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.model.entity.AutoBase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToAutoBaseDtoMapper {
    @Mapping(target = "orders", ignore = true)
    AutoBaseDto autoBaseToAutoBaseDto(AutoBase autoBase);
    @Mapping(target = "orders", ignore = true)
    AutoBase autoBaseDtoToAutoBase(AutoBaseDto autoBaseDto);
}
