package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.OrdersDto;
import com.andrei.myapp.model.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ToOrdersDtoMapper {
    @Mapping(target = "trips", ignore = true)
    OrdersDto ordersToOrdersDto(Orders orders);

    @Mappings({
            @Mapping(target = "trips", ignore = true),
            @Mapping(source = "orderStatus", target = "orderStatus")})
    Orders ordersDtoToOrders(OrdersDto ordersDto);
}
