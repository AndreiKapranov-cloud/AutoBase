package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.OrdersDto;
import com.andrei.myApp.mapper.ToOrdersDtoMapper;
import com.andrei.myApp.model.dao.OrderDao;
import com.andrei.myApp.model.entity.Orders;
import com.andrei.myApp.service.serviceInterfaces.OrderDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderDtoServiceImpl implements OrderDtoService {
    private final OrderDao dao;
    private final ToOrdersDtoMapper mapper;
    public OrderDtoServiceImpl(OrderDao dao, ToOrdersDtoMapper mapper) {
        this.dao = dao;

        this.mapper = mapper;
    }

    @Override
    public List<OrdersDto> getAll() {
        List<Orders> orders = dao.findAll();
        List<OrdersDto> ordersDtos = new ArrayList<>();
        orders.forEach(order -> {
            OrdersDto ordersDto = mapper.ordersToOrdersDto(order);
            ordersDtos.add(ordersDto);
        });
        return ordersDtos;
    }

    @Override
    public Orders save(OrdersDto ordersDto) {
        Orders orders =mapper.ordersDtoToOrders(ordersDto);
        return dao.save(orders);
    }

}
