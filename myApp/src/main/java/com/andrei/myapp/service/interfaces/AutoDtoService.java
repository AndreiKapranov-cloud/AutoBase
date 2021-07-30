package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.AutoDto;
import com.andrei.myapp.dto.RequestAutoDto;
import com.andrei.myapp.model.entity.Auto;

import java.util.List;

public interface AutoDtoService {
    List<AutoDto> getAll();
    AutoDto getAutoByAutoId(Long autoId);

    AutoDto getAutoByNumber(String number);

    List<AutoDto> getAutosByCarryingCapacityIsGreaterThan(int carryingCapacity);

    List<AutoDto> getAutosByMaxWeightWithCargoKgIsLessThan(int maxWeightWithCargoKg);

    List<AutoDto>getAutosByMaxVolumeM3After(int maxVolumeM3);

    List<AutoDto>getAutosByTechnicalInspection(String technicalInspection);

    Auto save(RequestAutoDto requestAutoDto);
}