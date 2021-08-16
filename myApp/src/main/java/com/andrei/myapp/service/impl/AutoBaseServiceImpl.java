package com.andrei.myapp.service.impl;

import com.andrei.myapp.model.dao.AutoBaseDao;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.service.interfaces.AutoBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AutoBaseServiceImpl implements AutoBaseService {
    private final AutoBaseDao dao;

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
    public synchronized AutoBase save(AutoBase autoBase) {
        return dao.save(autoBase);
    }
}
