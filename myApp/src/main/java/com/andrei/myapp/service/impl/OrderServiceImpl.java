package com.andrei.myapp.service.impl;

import com.andrei.myapp.model.dao.OrderDao;
import com.andrei.myapp.model.entity.Orders;
import com.andrei.myapp.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDao dao;

    @Override
    public List<Orders> getAll() {
        List<Orders> orders = dao.findAll();
        return orders;
    }

    @Override
    public Orders getOrdersByOrderId(Long orderId) {
        Orders orders = dao.getOrdersByOrderId(orderId);
        return orders;
    }

    @Override
    public Orders getOrdersByWeight(int weight) {
        Orders orders = dao.getOrdersByWeight(weight);
        return orders;
    }

    @Override
    public Orders save(Orders orders) {
        return dao.save(orders);
    }

}


