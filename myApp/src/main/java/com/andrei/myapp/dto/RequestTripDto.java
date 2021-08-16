package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTripDto {
    private Long tripId;
    private int distanceKm;
    private String tripStatus;
    private String orders;
    private String autoBase;
    private String dispatcher;
    private String driver;
}
