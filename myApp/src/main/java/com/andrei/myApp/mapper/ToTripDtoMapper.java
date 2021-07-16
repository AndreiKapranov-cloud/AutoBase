package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.TripDto;
import com.andrei.myApp.model.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ToAutoDtoMapper.class, ToAutoBaseDtoMapper.class, ToOrdersDtoMapper.class,
        ToUserDtoMapper.class, ToRoleDtoMapper.class}
)
public interface ToTripDtoMapper {
    @Mapping(target = "userRoles", ignore = true)
    TripDto tripToTripDto(Trip trip);
    @Mapping(target = "userRoles", ignore = true)
    Trip tripDtoToTrip(TripDto tripDto);
}