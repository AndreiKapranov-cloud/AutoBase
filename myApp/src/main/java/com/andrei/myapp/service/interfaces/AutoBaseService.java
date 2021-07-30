package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.model.entity.AutoBase;

import java.util.List;

public interface AutoBaseService {

    List<AutoBase> getAll();

    AutoBase getAutoBaseByNameOfOrganization(String nameOfOrganization);

    AutoBase getAutoBaseByAutoBaseId(Long autoBaseId);
    AutoBase save(AutoBase autoBase);
}
