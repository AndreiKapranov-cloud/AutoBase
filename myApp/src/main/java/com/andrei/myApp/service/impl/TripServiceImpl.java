package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.TripDto;
import com.andrei.myApp.mapper.TripTripDtoMapper;
import com.andrei.myApp.model.dao.TripDao;
import com.andrei.myApp.model.entity.Trip;
import com.andrei.myApp.service.serviceInterfaces.TripService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TripServiceImpl implements TripService {
    private final TripDao dao;
    private final TripTripDtoMapper mapper;
    public TripServiceImpl(TripDao dao, TripTripDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<TripDto> getAll() {
        List<Trip> trips = dao.findAll();
        List<TripDto> tripDtos = new ArrayList<>();
        trips.forEach(trip -> {
            TripDto tripDto = new TripDto();
            tripDto = mapper.tripToTripDto(trip);
            tripDtos.add(tripDto);
        });
        return tripDtos;
    }

    @Override
    public Trip save(TripDto tripDto) {
        Trip trip = new Trip();
        trip = mapper.tripDtoToTrip(tripDto);
        return dao.save(trip);

    }
}
