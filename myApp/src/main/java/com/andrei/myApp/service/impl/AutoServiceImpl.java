package com.andrei.myApp.service.impl;

import com.andrei.myApp.model.dao.AutoDao;
import com.andrei.myApp.model.entity.Auto;
import com.andrei.myApp.service.serviceInterfaces.AutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {
    private final AutoDao dao;

    public AutoServiceImpl(AutoDao dao) {
        this.dao = dao;

    }

    @Override
    public List<Auto> getAll() {
        List<Auto> autos = dao.findAll();
        return autos;
    }

    @Override
    public Auto getAutoByNumber(String number) {
        Auto auto = dao.getAutoByNumber(number);
        return auto;
    }
    @Override
    public Auto getAutoByAutoId(Long autoId) {
        Auto auto = dao.getAutoByAutoId(autoId);
        return auto;
    }
    @Override
    public List<Auto> getAutosByCarryingCapacityIsGreaterThan(int carryingCapacity) {
        List<Auto> autos = dao.getAutosByCarryingCapacityIsGreaterThan(carryingCapacity);
        return autos;

    }


    @Override
    public List<Auto> getAutosByMaxWeightWithCargoKgIsLessThan(int maxWeightWithCargoKg) {
        List<Auto> autos = dao.getAutosByMaxWeightWithCargoKgIsLessThan(maxWeightWithCargoKg);
        return autos;

    }

    @Override
    public List<Auto> getAutosByMaxVolumeM3After(int maxVolumeM3) {
        List<Auto> autos = dao.getAutosByMaxVolumeM3After(maxVolumeM3);
        return autos;
    }

    @Override
    public List<Auto> getAutosByTechnicalInspection(String technicalInspection) {
        List<Auto> autos = dao.getAutosByTechnicalInspection(technicalInspection);
        return autos;
    }

    @Override
    public Auto save(Auto auto) {
        return dao.save(auto);
    }
}