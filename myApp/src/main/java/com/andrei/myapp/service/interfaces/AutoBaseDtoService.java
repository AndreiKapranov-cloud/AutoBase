package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.model.entity.AutoBase;

import java.util.List;

public interface AutoBaseDtoService {

    List<AutoBaseDto> getAll();

    AutoBaseDto getAutoBaseByNameOfOrganization(String nameOfOrganization);

    AutoBaseDto getAutoBaseByAutoBaseId(Long autoBaseId);
    AutoBase save(AutoBaseDto autoBaseDto);
}
