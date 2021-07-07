package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
@Getter
@Setter
public class DriverDto {
    private Long driverId;
    private String driverName;
    private String driverSecondName;
    private List<TripDto> tripDtos;
}
