package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripDto {
    private Long tripId;
    private int distanceKm;
    private DriverDto driverDto;
    private AutoDto autoDto;
    private DispatcherDto dispatcherDto;
    private AutoBaseDto autoBaseDto;

}
