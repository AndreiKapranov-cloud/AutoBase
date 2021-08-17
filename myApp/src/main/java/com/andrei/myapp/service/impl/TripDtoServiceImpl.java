package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.*;
import com.andrei.myapp.google.GetDistanceMatrixApi;
import com.andrei.myapp.mapper.ToTripDtoMapper;
import com.andrei.myapp.mapper.TripToRequestTripDtoMapperImpl;
import com.andrei.myapp.model.dao.TripDao;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import com.andrei.myapp.service.interfaces.OrderDtoService;
import com.andrei.myapp.service.interfaces.TripDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripDtoServiceImpl implements TripDtoService {
    private final TripToRequestTripDtoMapperImpl tripToRequestTripDtoMapperImpl;
    private final TripDao dao;
    private final ToTripDtoMapper mapper;
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final OrderDtoService orderDtoService;
    private final GetDistanceMatrixApi getDistanceMatrixApi;

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
    public String tripDispatcherHelper() {
     //   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     //   String login = auth.getName();
        UserDto dispatcherr = userDtoService.getUserByLogin("1");
        return String.valueOf(dispatcherr.getUserId());
    }

    @Override
    public String tripOrderHelper(Long orderId) {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        return String.valueOf(orderId);
    }

    @Override
    public List<UserDto> tripDriversHelper(Long orderId) {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        return userDtoService.
                getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThanAndAuto_maxVolumeM3IsGreaterThan
                        (UserEnum.READY, ordersDto.getWeight(), ordersDto.getVolumeM3());
    }

    @Override
    public long tripGetDistanceKm(Long orderId) throws Exception {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        String destination = ordersDto.getDeliveryAddress();
        String source = "Grodno";
        return getDistanceMatrixApi.getData(source, destination) * 2;
    }

    @Override
    @Transactional
    public Trip save(TripDto tripDto) {
        Trip trip = mapper.tripDtoToTrip(tripDto);
        return dao.save(trip);
    }

    @Override
    public TripDto getTripByTripId(Long tripId) {
        Trip trip = dao.getTripByTripId(tripId);
        return mapper.tripToTripDto(trip);
    }

    @Override
    public List<TripDto> getTripsByDriver(User driver) {
        List<Trip> trips = dao.getTripsByDriver(driver);
        List<TripDto> tripDtos = new ArrayList<>();
        trips.forEach(trip -> {
            TripDto tripDto = new TripDto();
            tripDto = mapper.tripToTripDto(trip);
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
            tripDto = mapper.tripToTripDto(trip);
            tripDtos.add(tripDto);
        });
        return tripDtos;
    }
}
