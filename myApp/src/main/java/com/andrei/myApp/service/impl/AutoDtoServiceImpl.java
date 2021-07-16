package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.AutoDto;
import com.andrei.myApp.mapper.ToAutoDtoMapper;
import com.andrei.myApp.model.dao.AutoDao;
import com.andrei.myApp.model.entity.Auto;
import com.andrei.myApp.service.serviceInterfaces.AutoDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoDtoServiceImpl implements AutoDtoService {

  private final AutoDao dao;
    private final ToAutoDtoMapper mapper;
    public AutoDtoServiceImpl(AutoDao dao, ToAutoDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<AutoDto> getAll() {
        List<Auto> autos = dao.findAll();
        List<AutoDto> autoDtos = new ArrayList<>();
        autos.forEach(auto -> {
            AutoDto autoDto = mapper.autoToAutoDto(auto);
            autoDtos.add(autoDto);
        });
        return autoDtos;
    }

    @Override
    public AutoDto getAutoByNumber(String number) {
        Auto auto = dao.getAutoByNumber(number);
        AutoDto autoDto = new AutoDto();
       autoDto = mapper.autoToAutoDto(auto);
        return autoDto;
    }
    @Override
    public AutoDto getAutoByAutoId(Long autoId) {
        Auto auto = dao.getAutoByAutoId(autoId);
        AutoDto autoDto = new AutoDto();
        autoDto = mapper.autoToAutoDto(auto);
        return autoDto;
    }
    @Override
    public List<AutoDto> getAutosByCarryingCapacityIsGreaterThan(int carryingCapacity) {
        List<Auto> autos = dao.getAutosByCarryingCapacityIsGreaterThan(carryingCapacity);
        List<AutoDto> autoDtos = new ArrayList<>();
        autos.forEach(auto -> {
            AutoDto autoDto = mapper.autoToAutoDto(auto);
            autoDtos.add(autoDto);
        });
        return autoDtos;

    }


    @Override
    public List<AutoDto> getAutosByMaxWeightWithCargoKgIsLessThan(int maxWeightWithCargoKg) {
        List<Auto> autos = dao.getAutosByMaxWeightWithCargoKgIsLessThan(maxWeightWithCargoKg);
        List<AutoDto> autoDtos = new ArrayList<>();
        autos.forEach(auto -> {
            AutoDto autoDto = mapper.autoToAutoDto(auto);
            autoDtos.add(autoDto);
        });
        return autoDtos;

    }

    @Override
    public List<AutoDto> getAutosByMaxVolumeM3After(int maxVolumeM3) {
        List<Auto> autos = dao.getAutosByMaxVolumeM3After(maxVolumeM3);
        List<AutoDto> autoDtos = new ArrayList<>();
        autos.forEach(auto -> {
            AutoDto autoDto = mapper.autoToAutoDto(auto);
            autoDtos.add(autoDto);
        });
        return autoDtos;
    }

    @Override
    public List<AutoDto> getAutosByTechnicalInspection(String technicalInspection) {
        List<Auto> autos = dao.getAutosByTechnicalInspection(technicalInspection);
        List<AutoDto> autoDtos = new ArrayList<>();
        autos.forEach(auto -> {
            AutoDto autoDto = mapper.autoToAutoDto(auto);
            autoDtos.add(autoDto);
        });
        return autoDtos;
    }

    @Override
    public Auto save(AutoDto autoDto) {
       Auto auto =mapper.autoDtoToAuto(autoDto);
        return dao.save(auto);
    }
}
