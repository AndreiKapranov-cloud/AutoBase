package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Orders,Long> {
    Orders getOrdersByOrderId(Long orderId);
}
