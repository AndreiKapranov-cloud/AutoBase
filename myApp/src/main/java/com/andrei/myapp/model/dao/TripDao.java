package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDao extends JpaRepository<Trip,Long> {
    Trip getTripByTripId(Long tripId);
}
