package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.AutoDto;
import com.andrei.myApp.model.entity.Auto;
import com.andrei.myApp.model.entity.AutoBase;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")

    public interface AutoAutoDtoMapper {

        AutoDto autoToAutoDto(Auto auto);
        Auto autoDtoToAuto(AutoDto autoDto);

    }
