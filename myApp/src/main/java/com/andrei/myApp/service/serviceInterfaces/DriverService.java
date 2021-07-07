package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.DriverDto;
import com.andrei.myApp.model.entity.Driver;

import java.util.List;

public interface DriverService {
    List<DriverDto> getAll();

    Driver save(DriverDto driverDto);
}
