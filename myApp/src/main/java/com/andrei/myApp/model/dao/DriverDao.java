package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends JpaRepository<Driver,Long> {

}
