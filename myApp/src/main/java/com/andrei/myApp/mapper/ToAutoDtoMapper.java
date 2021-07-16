package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.AutoDto;
import com.andrei.myApp.model.entity.Auto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

    public interface ToAutoDtoMapper {

        AutoDto autoToAutoDto(Auto auto);

        Auto autoDtoToAuto(AutoDto autoDto);

    }
