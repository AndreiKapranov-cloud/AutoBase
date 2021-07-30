package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTripDto {
    private Long tripId;
    private int distanceKm;
    private Boolean finished;
    private String autoBase;
    private String orders;
    private String dispatcher ;
    private String driver;
}
