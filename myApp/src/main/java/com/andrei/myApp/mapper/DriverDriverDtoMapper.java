package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.DriverDto;
import com.andrei.myApp.model.entity.Driver;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface DriverDriverDtoMapper {
    DriverDto driverToDriverDto(Driver driver);
    Driver driverDtoToDriver(DriverDto driverDto);

}
