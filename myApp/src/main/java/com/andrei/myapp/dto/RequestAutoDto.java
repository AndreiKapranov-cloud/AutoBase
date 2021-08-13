package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAutoDto {
    private Long autoId;
    private String number;
    private int carryingCapacity;
    private int maxWeightWithCargoKg;
    private int maxVolumeM3;
    private Boolean technicalInspection;
    private String driver;
    private int fuelConsumption;
}
