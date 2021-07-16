package com.andrei.myApp.service.impl;

import com.andrei.myApp.model.dao.TripDao;
import com.andrei.myApp.model.entity.Trip;
import com.andrei.myApp.service.serviceInterfaces.TripService;
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
}
