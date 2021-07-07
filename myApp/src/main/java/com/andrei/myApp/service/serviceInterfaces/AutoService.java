package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.AutoDto;
import com.andrei.myApp.model.entity.Auto;

import java.util.List;

public interface AutoService {
    List<AutoDto> getAll();
    AutoDto getAutoByAutoId(Long autoId);

    AutoDto getAutoByNumber(String number);

    List<AutoDto> getAutosByCarryingCapacityIsGreaterThan(int carryingCapacity);

    List<AutoDto> getAutosByMaxWeightWithCargoKgIsLessThan(int maxWeightWithCargoKg);

    List<AutoDto>getAutosByMaxVolumeM3After(int maxVolumeM3);

    List<AutoDto>getAutosByTechnicalInspection(String technicalInspection);

    Auto save(AutoDto autoDto);
}