package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.Trip;

import java.util.List;

public interface TripService {
    List<Trip> getAll();
    Trip getTripByTripId(Long tripId);
    Trip save(Trip trip);
}
