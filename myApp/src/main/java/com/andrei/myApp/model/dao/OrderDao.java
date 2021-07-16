package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Orders,Long> {
}
