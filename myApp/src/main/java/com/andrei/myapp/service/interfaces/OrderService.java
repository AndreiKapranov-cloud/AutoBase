package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.model.entity.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAll();

    Orders getOrdersByOrderId(Long orderId);

    Orders save(Orders order);
}
