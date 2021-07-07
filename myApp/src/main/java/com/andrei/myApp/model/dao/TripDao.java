package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDao extends JpaRepository<Trip,Long> {

}
