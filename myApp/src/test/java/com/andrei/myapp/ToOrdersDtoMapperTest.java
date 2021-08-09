package com.andrei.myapp;


import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.dto.OrdersDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.mapper.ToAutoBaseDtoMapper;
import com.andrei.myapp.mapper.ToOrdersDtoMapper;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.model.entity.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToOrdersDtoMapperTest {

    private final ToOrdersDtoMapper mapper
            = Mappers.getMapper(ToOrdersDtoMapper.class);

    @org.junit.Test
    public void givenToOrdersDtoMapper_whenMaps_thenCorrect() {
        Orders orders= new Orders();
        orders.setTermOfDelivery(Date.valueOf("2021-12-12"));
        orders.setWeight(12);
        orders.setDeliveryAddress("Pushkina,21");
        OrdersDto ordersDto=mapper.ordersToOrdersDto(orders);
        assertEquals(orders.getTermOfDelivery(),ordersDto.getTermOfDelivery());
        assertEquals(orders.getWeight(), ordersDto.getWeight());
        assertEquals(orders.getWeight(), ordersDto.getWeight());
        assertEquals(orders.getDeliveryAddress(), ordersDto.getDeliveryAddress());
    }

}
