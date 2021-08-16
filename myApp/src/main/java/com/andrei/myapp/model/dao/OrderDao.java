package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Orders, Long> {
    Orders getOrdersByOrderId(Long orderId);

    List<Orders> findOrdersByOrderId(Long orderId);
}
