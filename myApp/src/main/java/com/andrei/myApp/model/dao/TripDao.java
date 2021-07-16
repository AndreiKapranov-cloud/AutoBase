package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Trip;
import com.andrei.myApp.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip,Long> {

}
