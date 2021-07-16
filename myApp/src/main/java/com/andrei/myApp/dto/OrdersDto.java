package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
public class OrdersDto {
    private Long orderId;
    private Date termOfDelivery;
    private int weight;
    private String deliveryAddress;
    private List<TripDto> trips;

}
