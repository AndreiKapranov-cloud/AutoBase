package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.AutoDto;
import com.andrei.myapp.model.entity.Auto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

    public interface ToAutoDtoMapper {
    @Mapping(target = "driver", ignore = true)
        AutoDto autoToAutoDto(Auto auto);
    @Mapping(target = "driver", ignore = true)
        Auto autoDtoToAuto(AutoDto autoDto);

    }
