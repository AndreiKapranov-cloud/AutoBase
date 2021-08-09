package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.mapper.ToTripDtoMapper;
import com.andrei.myapp.mapper.TripToRequestTripDtoMapperImpl;
import com.andrei.myapp.model.dao.TripDao;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.service.interfaces.TripDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class TripDtoServiceImpl implements TripDtoService {
    private final TripToRequestTripDtoMapperImpl tripToRequestTripDtoMapperImpl;
    private final TripDao dao;
    private final ToTripDtoMapper mapper;
    public TripDtoServiceImpl(TripToRequestTripDtoMapperImpl tripToRequestTripDtoMapperImpl, TripDao dao, ToTripDtoMapper mapper) {
        this.tripToRequestTripDtoMapperImpl = tripToRequestTripDtoMapperImpl;

        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<TripDto> getAll() {
        List<Trip> trips = dao.findAll();
        List<TripDto> tripDtos = new ArrayList<>();
        trips.forEach(trip -> {
            TripDto tripDto = new TripDto();
            tripDto=mapper.tripToTripDto(trip);
            tripDtos.add(tripDto);
        });
        return tripDtos;
    }

   @Override
   @Transactional
    public Trip save(RequestTripDto requestTripDto) {
        Trip trip= tripToRequestTripDtoMapperImpl.requestTripDtoToTrip(requestTripDto);
        return dao.save(trip);
    }
@Override
public RequestTripDto getTripByTripId(Long tripId){
        Trip trip = dao.getTripByTripId(tripId);
        RequestTripDto requestTripDto = tripToRequestTripDtoMapperImpl.tripToRequestTripDto(trip);
        return requestTripDto;
}

    @Override
    public List<TripDto> getTripsByDriver(User driver) {
            List<Trip> trips = dao.getTripsByDriver(driver);
            List<TripDto> tripDtos = new ArrayList<>();
            trips.forEach(trip -> {
                TripDto tripDto = new TripDto();
                tripDto=mapper.tripToTripDto(trip);
                tripDtos.add(tripDto);
            });
            return tripDtos;
        }
    @Override
    public List<TripDto> getTripsByDispatcher(User dispatcher) {
        List<Trip> trips = dao.getTripsByDispatcher(dispatcher);
        List<TripDto> tripDtos = new ArrayList<>();
        trips.forEach(trip -> {
            TripDto tripDto = new TripDto();
            tripDto=mapper.tripToTripDto(trip);
            tripDtos.add(tripDto);
        });
        return tripDtos;
    }
}
