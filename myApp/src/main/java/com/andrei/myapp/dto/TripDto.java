package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripDto {
    private Long tripId;
    private int distanceKm;
    private Boolean finished;
    private AutoBaseDto autoBase;
    private OrdersDto orders;
    private UserDto dispatcher ;
    private UserDto driver;
}
