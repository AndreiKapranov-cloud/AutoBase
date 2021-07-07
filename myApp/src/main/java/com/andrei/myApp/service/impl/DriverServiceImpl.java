package com.andrei.myApp.service.impl;

import com.andrei.myApp.mapper.DriverDriverDtoMapper;
import com.andrei.myApp.dto.DriverDto;
import com.andrei.myApp.model.dao.DriverDao;
import com.andrei.myApp.model.entity.Driver;
import com.andrei.myApp.service.serviceInterfaces.DriverService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DriverServiceImpl implements DriverService {
    private final DriverDao dao;
    private final DriverDriverDtoMapper mapper;
    public DriverServiceImpl(DriverDao dao, DriverDriverDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<DriverDto> getAll() {
        List<Driver> drivers = dao.findAll();
        List<DriverDto> driverDtos = new ArrayList<>();
        drivers.forEach(driver -> {
            DriverDto driverDto = mapper.driverToDriverDto(driver);
            driverDtos.add(driverDto);
        });
        return driverDtos;
    }

    @Override
    public Driver save(DriverDto driverDto) {
        Driver driver = new Driver();
       driver =mapper.driverDtoToDriver(driverDto);
        return dao.save(driver);
    }

}
