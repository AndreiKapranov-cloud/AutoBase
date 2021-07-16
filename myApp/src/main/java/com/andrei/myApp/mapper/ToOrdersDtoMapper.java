package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.OrdersDto;
import com.andrei.myApp.model.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToOrdersDtoMapper {
    @Mapping(target = "trips", ignore = true)
    OrdersDto ordersToOrdersDto(Orders orders);
    @Mapping(target = "trips", ignore = true)
    Orders ordersDtoToOrders(OrdersDto ordersDto);

}
