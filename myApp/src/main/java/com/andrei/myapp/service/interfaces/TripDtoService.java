package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;

import java.util.List;

public interface TripDtoService {
    List<TripDto> getAll();

    String tripDispatcherHelper();

    long tripGetDistanceKm(Long orderId) throws Exception;

    String tripOrderHelper(Long orderId);

    Trip save(RequestTripDto requestTripDto);

    List<UserDto> tripDriversHelper(Long orderId);

    RequestTripDto getRequestTripDtoByTripId(Long TripId);

    TripDto getTripByTripId(Long TripId);

    List<TripDto> getTripsByDriver(User driver);

    List<TripDto> getTripsByDispatcher(User Dispatcher);
}
