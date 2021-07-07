package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.TripDto;
import com.andrei.myApp.model.entity.Trip;

import java.util.List;

public interface TripService {
    List<TripDto> getAll();

    Trip save(TripDto tripDto);
}
