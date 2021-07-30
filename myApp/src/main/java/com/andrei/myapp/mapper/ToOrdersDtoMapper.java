package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.OrdersDto;
import com.andrei.myapp.model.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToOrdersDtoMapper {
    @Mapping(target = "trips", ignore = true)
    OrdersDto ordersToOrdersDto(Orders orders);
    @Mapping(target = "trips", ignore = true)
    Orders ordersDtoToOrders(OrdersDto ordersDto);

}
