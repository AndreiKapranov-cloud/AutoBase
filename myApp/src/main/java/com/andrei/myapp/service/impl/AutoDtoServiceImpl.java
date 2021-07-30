package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.AutoDto;
import com.andrei.myapp.dto.RequestAutoDto;
import com.andrei.myapp.mapper.AutoToRequestAutoDtoMapper;
import com.andrei.myapp.mapper.ToAutoDtoMapper;
import com.andrei.myapp.model.dao.AutoDao;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.service.interfaces.AutoDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoDtoServiceImpl implements AutoDtoService {

    private final AutoDao dao;
    private final ToAutoDtoMapper mapper;
    private final AutoToRequestAutoDtoMapper autoToRequestAutoDtoMapper;
    public AutoDtoServiceImpl(AutoDao dao, ToAutoDtoMapper mapper, AutoToRequestAutoDtoMapper autoToRequestAutoDtoMapper) {
        this.dao = dao;
        this.mapper = mapper;
        this.autoToRequestAutoDtoMapper = autoToRequestAutoDtoMapper;
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
    @Transactional
    public Auto save(RequestAutoDto requestAutoDto) {
        Auto auto = autoToRequestAutoDtoMapper.requestAutoDtoToAuto(requestAutoDto);
        return dao.save(auto);
    }
}
