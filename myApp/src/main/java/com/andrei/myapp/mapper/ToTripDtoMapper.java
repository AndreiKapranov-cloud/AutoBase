package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.model.entity.Trip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ToAutoDtoMapper.class, ToAutoBaseDtoMapper.class, ToOrdersDtoMapper.class,
        ToUserDtoMapper.class, ToRoleDtoMapper.class}
)
public interface ToTripDtoMapper {

    TripDto tripToTripDto(Trip trip);

    Trip tripDtoToTrip(TripDto tripDto);
}