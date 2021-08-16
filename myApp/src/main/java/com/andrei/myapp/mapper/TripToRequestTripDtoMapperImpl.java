package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.enums.TripEnumConverter;
import com.andrei.myapp.service.impl.*;
import com.andrei.myapp.service.interfaces.AutoBaseService;
import com.andrei.myapp.service.interfaces.OrderService;
import com.andrei.myapp.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripToRequestTripDtoMapperImpl {
    private final AutoBaseService autoBaseService;
    private final OrderService orderService;
    private final UserService userService;

    TripEnumConverter tripEnumConverter = new TripEnumConverter();

    public TripToRequestTripDtoMapperImpl(AutoBaseService autoBaseService, OrderService orderService, UserService userService) {
        this.autoBaseService = autoBaseService;
        this.orderService = orderService;
        this.userService = userService;
    }

    public RequestTripDto tripToRequestTripDto(Trip trip) {
        RequestTripDto requestTripDto = new RequestTripDto();
        requestTripDto.setTripId(trip.getTripId());
        requestTripDto.setDistanceKm(trip.getDistanceKm());
        requestTripDto.setTripStatus(tripEnumConverter.convertToDatabaseColumn(trip.getTripStatus()));
        requestTripDto.setOrders(String.valueOf((trip.getOrders()).getOrderId()));
        requestTripDto.setAutoBase(String.valueOf((trip.getAutoBase()).getAutoBaseId()));
        requestTripDto.setDispatcher(String.valueOf((trip.getDispatcher()).getUserId()));
        requestTripDto.setDriver(String.valueOf((trip.getDriver()).getUserId()));
        return requestTripDto;
    }

    public Trip requestTripDtoToTrip(RequestTripDto requestTripDto) {
        Trip trip = new Trip();
        trip.setTripId(requestTripDto.getTripId());
        trip.setDistanceKm(requestTripDto.getDistanceKm());
        trip.setTripStatus(tripEnumConverter.convertToEntityAttribute(requestTripDto.getTripStatus()));
        trip.setAutoBase(autoBaseService.getAutoBaseByAutoBaseId(Long.valueOf(requestTripDto.getAutoBase())));
        trip.setOrders(orderService.getOrdersByOrderId(Long.valueOf(requestTripDto.getOrders())));
        trip.setDispatcher(userService.getUserById(Long.valueOf(requestTripDto.getDispatcher())));
        trip.setDriver(userService.getUserById(Long.valueOf(requestTripDto.getDriver())));
        return trip;
    }
}

