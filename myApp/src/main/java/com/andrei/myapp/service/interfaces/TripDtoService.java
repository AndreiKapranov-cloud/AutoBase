package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.model.entity.Trip;

import java.util.List;

public interface TripDtoService {
    List<TripDto> getAll();
   Trip save(RequestTripDto requestTripDto);
   RequestTripDto getTripByTripId(Long TripId);

}
