package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class OrdersDto {
    private Long orderId;
    private Date termOfDelivery;
    private int weight;
    private int volumeM3;
    private String orderStatus;
    private String deliveryAddress;
    private List<TripDto> trips;

}
