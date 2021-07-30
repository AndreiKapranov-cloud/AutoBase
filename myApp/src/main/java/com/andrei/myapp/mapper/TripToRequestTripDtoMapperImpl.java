package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.service.impl.*;
import org.springframework.stereotype.Component;

@Component
public class TripToRequestTripDtoMapperImpl {
    private final AutoBaseServiceImpl autoBaseService;
    private final OrderServiceImpl orderService;
    private final UserServiceImpl userService;

    public TripToRequestTripDtoMapperImpl(AutoBaseServiceImpl autoBaseService, OrderServiceImpl orderService, UserServiceImpl userService) {
        this.autoBaseService = autoBaseService;
        this.orderService = orderService;
        this.userService = userService;
    }

    public RequestTripDto tripToRequestTripDto(Trip trip) {
        RequestTripDto requestTripDto = new RequestTripDto();
        requestTripDto.setTripId(trip.getTripId());
        requestTripDto.setDistanceKm(trip.getDistanceKm());
        requestTripDto.setFinished(trip.getFinished());
        requestTripDto.setAutoBase(String.valueOf(trip.getAutoBase()));
        requestTripDto.setOrders(String.valueOf(trip.getOrders()));
        requestTripDto.setDispatcher(String.valueOf(trip.getDispatcher()));
        requestTripDto.setDriver(String.valueOf(trip.getDriver()));
        return requestTripDto;
    }

    public Trip requestTripDtoToTrip(RequestTripDto requestTripDto) {
        Trip trip = new Trip();
        trip.setTripId(requestTripDto.getTripId());
        trip.setDistanceKm(requestTripDto.getDistanceKm());
        trip.setFinished(requestTripDto.getFinished());
        trip.setAutoBase(autoBaseService.getAutoBaseByAutoBaseId(Long.valueOf(requestTripDto.getAutoBase())));
        trip.setOrders(orderService.getOrdersByOrderId(Long.valueOf(requestTripDto.getOrders())));
        trip.setDispatcher(userService.getUserById(Long.valueOf(requestTripDto.getDispatcher())));
        trip.setDriver(userService.getUserById(Long.valueOf(requestTripDto.getDriver())));
        return trip;
    }
}

