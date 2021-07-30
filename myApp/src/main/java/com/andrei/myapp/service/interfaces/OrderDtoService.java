package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.OrdersDto;
import com.andrei.myapp.model.entity.Orders;

import java.util.List;

public interface OrderDtoService {
    List<OrdersDto> getAll();
OrdersDto getOrdersByOrderId(Long orderId);
    Orders save(OrdersDto ordersDto);
}
