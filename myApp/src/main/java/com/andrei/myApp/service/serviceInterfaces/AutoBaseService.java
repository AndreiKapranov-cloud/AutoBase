package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.model.entity.AutoBase;

import java.util.List;

public interface AutoBaseService {

    List<AutoBase> getAll();

    AutoBase getAutoBaseByNameOfOrganization(String nameOfOrganization);

    AutoBase getAutoBaseByAutoBaseId(Long autoBaseId);
    AutoBase save(AutoBase autoBase);
}
