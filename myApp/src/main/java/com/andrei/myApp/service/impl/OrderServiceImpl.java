package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.OrderDto;
import com.andrei.myApp.mapper.OrderOrderDtoMapper;
import com.andrei.myApp.model.dao.OrderDao;
import com.andrei.myApp.model.entity.Order;
import com.andrei.myApp.service.serviceInterfaces.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao dao;
    private final OrderOrderDtoMapper mapper;
    public OrderServiceImpl(OrderDao dao, OrderOrderDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orders = dao.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        orders.forEach(order -> {
            OrderDto orderDto = mapper.orderToOrderDto(order);
            orderDtos.add(orderDto);
        });
        return orderDtos;
    }

    @Override
    public Order save(Order order) {


        return dao.save(order);
    }

}
