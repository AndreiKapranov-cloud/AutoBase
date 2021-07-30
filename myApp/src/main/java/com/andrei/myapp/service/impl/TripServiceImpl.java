package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.model.dao.TripDao;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.service.interfaces.TripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    private final TripDao dao;

    public TripServiceImpl(TripDao dao) {
        this.dao = dao;

    }

    @Override
    public List<Trip> getAll() {
        List<Trip> trips = dao.findAll();
        return trips;
    }

    @Override
    public Trip save(Trip trip) {
        return dao.save(trip);

    }
    @Override
    public Trip getTripByTripId(Long tripId) {
        Trip trip = dao.getTripByTripId(tripId);
        return trip;
    }
}
