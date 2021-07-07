package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.DispatcherDto;
import com.andrei.myApp.dto.OrderDto;
import com.andrei.myApp.model.entity.Dispatcher;
import com.andrei.myApp.model.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface OrderOrderDtoMapper {
    OrderDto orderToOrderDto(Order order);
    Order orderDtoToOrder(OrderDto orderDto);

}
