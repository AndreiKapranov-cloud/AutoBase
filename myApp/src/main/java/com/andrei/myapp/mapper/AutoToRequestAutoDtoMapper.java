package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestAutoDto;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.service.interfaces.UserService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AutoToRequestAutoDtoMapper {
    private final UserService userService;

    public AutoToRequestAutoDtoMapper(UserService userService) {
        this.userService = userService;

    }

    public Auto requestAutoDtoToAuto(RequestAutoDto requestAutoDto) {
        Auto auto = new Auto();
        auto.setAutoId(requestAutoDto.getAutoId());
        auto.setNumber(requestAutoDto.getNumber());
        auto.setCarryingCapacity(requestAutoDto.getCarryingCapacity());
        auto.setMaxWeightWithCargoKg(requestAutoDto.getMaxWeightWithCargoKg());
        auto.setMaxVolumeM3(requestAutoDto.getMaxVolumeM3());
        auto.setTechnicalInspection(requestAutoDto.getTechnicalInspection());
        auto.setDriver(userService.getUserById(Long.valueOf(requestAutoDto.getDriver())));
        return auto;
    }

}
