package com.andrei.myapp;

import com.andrei.myapp.dto.OrdersDto;
import com.andrei.myapp.model.dao.OrderDao;
import com.andrei.myapp.model.entity.Orders;
import com.andrei.myapp.service.interfaces.OrderDtoService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDtoServiceImplTest {
    @Autowired
    OrderDtoService orderDtoService;
    @MockBean
    OrderDao dao;
    private final Long id = 1L;
    int weight = 300;

    @Before
    public void setUp() {
        Orders orders = new Orders();
        orders.setOrderId(id);
        orders.setWeight(weight);
        Mockito.when(dao.getOrdersByOrderId(id)).thenReturn(orders);
        Mockito.when(dao.getOrdersByWeight(weight)).thenReturn(orders);
    }

    @org.junit.Test
    public void getOrdersByOrderIdTest() {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(id);
        Assertions.assertNotEquals(null, ordersDto);
    }

    @org.junit.Test
    public void getOrdersByWeight() {
        OrdersDto ordersDto = orderDtoService.getOrdersByWeight(weight);
        Assertions.assertNotEquals(null, ordersDto);
    }
}



