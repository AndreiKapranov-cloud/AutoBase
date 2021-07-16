package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.OrdersDto;
import com.andrei.myApp.model.entity.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAll();

    Orders save(Orders order);
}
