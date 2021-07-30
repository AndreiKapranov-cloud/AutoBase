package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoDao extends JpaRepository<Auto, Long> {
    Auto getAutoByAutoId(Long autoId);

    Auto getAutoByNumber(String number);

    List<Auto> getAutosByCarryingCapacityIsGreaterThan(int carryingCapacity);

    List<Auto> getAutosByMaxWeightWithCargoKgIsLessThan(int maxWeightWithCargoKg);

    List<Auto> getAutosByMaxVolumeM3After(int maxVolumeM3);

    List<Auto> getAutosByTechnicalInspection(String technicalInspection);

}
