package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.model.entity.AutoBase;

import java.util.List;

public interface AutoBaseDtoService {

    List<AutoBaseDto> getAll();

    AutoBaseDto getAutoBaseByNameOfOrganization(String nameOfOrganization);

    AutoBaseDto getAutoBaseByAutoBaseId(Long autoBaseId);
    AutoBase save(AutoBaseDto autoBaseDto);
}
