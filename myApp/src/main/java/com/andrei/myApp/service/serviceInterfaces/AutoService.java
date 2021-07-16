package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.AutoDto;
import com.andrei.myApp.model.entity.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAll();
    Auto getAutoByAutoId(Long autoId);

    Auto getAutoByNumber(String number);

    List<Auto> getAutosByCarryingCapacityIsGreaterThan(int carryingCapacity);

    List<Auto> getAutosByMaxWeightWithCargoKgIsLessThan(int maxWeightWithCargoKg);

    List<Auto>getAutosByMaxVolumeM3After(int maxVolumeM3);

    List<Auto>getAutosByTechnicalInspection(String technicalInspection);

    Auto save(Auto auto);
}
