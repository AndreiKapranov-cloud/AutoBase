package com.andrei.myApp.service.impl;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.mapper.ToAutoBaseDtoMapper;
import com.andrei.myApp.model.dao.AutoBaseDao;
import com.andrei.myApp.model.entity.AutoBase;
import com.andrei.myApp.service.serviceInterfaces.AutoBaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AutoBaseServiceImpl implements AutoBaseService {
    private final AutoBaseDao dao;


    public AutoBaseServiceImpl(AutoBaseDao dao) {
        this.dao = dao;

    }

    @Override
    public List<AutoBase> getAll() {
        List<AutoBase> autoBases = dao.findAll();
        return autoBases;
    }

    @Override
    public AutoBase getAutoBaseByNameOfOrganization(String nameOfOrganization) {
        AutoBase autoBase = dao.getAutoBaseByNameOfOrganization(nameOfOrganization);
        return autoBase;
    }
    @Override
    public AutoBase getAutoBaseByAutoBaseId(Long autoBaseId){
        AutoBase autoBase =dao.getAutoBaseByAutoBaseId(autoBaseId);
        return autoBase;
    }


    @Override
    public AutoBase save(AutoBase autoBase) {
        return dao.save(autoBase);
    }
}
