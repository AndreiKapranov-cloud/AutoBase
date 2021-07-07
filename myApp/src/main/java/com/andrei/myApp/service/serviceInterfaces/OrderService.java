package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.OrderDto;
import com.andrei.myApp.model.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAll();

    Order save(Order order);
}
