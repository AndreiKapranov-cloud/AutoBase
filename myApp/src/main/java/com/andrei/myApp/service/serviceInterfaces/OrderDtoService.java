package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.OrdersDto;
import com.andrei.myApp.model.entity.Orders;

import java.util.List;

public interface OrderDtoService {
    List<OrdersDto> getAll();

    Orders save(OrdersDto ordersDto);
}