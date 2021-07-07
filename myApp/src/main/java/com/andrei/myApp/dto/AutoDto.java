package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AutoDto {
    private Long autoId;
    private String number;
    private int carryingCapacity;
    private int maxWeightWithCargoKg;
    private int maxVolumeM3;
    private String technicalInspection;
    private List<TripDto> tripDtos;
}
