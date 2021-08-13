package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;

import java.util.List;

public interface TripDtoService {
    List<TripDto> getAll();

    Trip save(RequestTripDto requestTripDto);

    RequestTripDto getTripByTripId(Long TripId);

    List<TripDto> getTripsByDriver(User driver);

    List<TripDto> getTripsByDispatcher(User Dispatcher);
}
