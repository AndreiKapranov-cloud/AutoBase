package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.OrdersDto;
import com.andrei.myapp.mapper.ToOrdersDtoMapper;
import com.andrei.myapp.model.dao.OrderDao;
import com.andrei.myapp.model.entity.Orders;
import com.andrei.myapp.service.interfaces.OrderDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public OrdersDto getOrdersByOrderId(Long orderId) {
        Orders orders = dao.getOrdersByOrderId(orderId);
        OrdersDto ordersDto = mapper.ordersToOrdersDto(orders);
        return ordersDto;
    }

    @Override
    @Transactional
    public synchronized Orders save(OrdersDto ordersDto) {
        Orders orders = mapper.ordersDtoToOrders(ordersDto);
        return dao.save(orders);
    }

}