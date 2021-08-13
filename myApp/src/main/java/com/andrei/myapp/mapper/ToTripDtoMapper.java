package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.model.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ToAutoDtoMapper.class, ToAutoBaseDtoMapper.class, ToOrdersDtoMapper.class,
        ToUserDtoMapper.class, ToRoleDtoMapper.class}
)
public interface ToTripDtoMapper {

    TripDto tripToTripDto(Trip trip);
    @Mapping(source = "tripStatus", target = "tripStatus")
    Trip tripDtoToTrip(TripDto tripDto);
}