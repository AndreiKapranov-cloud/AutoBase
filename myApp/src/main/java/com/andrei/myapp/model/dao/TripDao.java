package com.andrei.myapp.model.dao;

import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip,Long> {
    Trip getTripByTripId(Long tripId);
    List<Trip> getTripsByDriver(User driver);
    List<Trip> getTripsByDispatcher(User Dispatcher);
}
