package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.*;
import com.andrei.myApp.model.entity.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
@Mapper(componentModel = "spring")
public interface TripTripDtoMapper {
    TripDto tripToTripDto(Trip trip);

    Trip tripDtoToTrip(TripDto tripDto);
}