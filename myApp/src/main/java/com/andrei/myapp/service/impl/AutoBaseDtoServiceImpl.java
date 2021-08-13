package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.mapper.ToAutoBaseDtoMapper;
import com.andrei.myapp.model.dao.AutoBaseDao;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoBaseDtoServiceImpl implements AutoBaseDtoService {

    private final AutoBaseDao dao;
    private final ToAutoBaseDtoMapper mapper;

    public AutoBaseDtoServiceImpl(AutoBaseDao dao, ToAutoBaseDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<AutoBaseDto> getAll() {
        List<AutoBase> autoBases = dao.findAll();
        List<AutoBaseDto> autoBaseDtos = new ArrayList<>();
        autoBases.forEach(autoBase1 -> {
            AutoBaseDto autoBase = mapper.autoBaseToAutoBaseDto(autoBase1);
            autoBaseDtos.add(autoBase);
        });
        return autoBaseDtos;
    }

    @Override
    public AutoBaseDto getAutoBaseByNameOfOrganization(String nameOfOrganization) {
        AutoBase autoBase = dao.getAutoBaseByNameOfOrganization(nameOfOrganization);
        AutoBaseDto autoBaseDto = mapper.autoBaseToAutoBaseDto(autoBase);
        return autoBaseDto;
    }
    @Override
     public AutoBaseDto getAutoBaseByAutoBaseId(Long autoBaseId){
        AutoBase autoBase =dao.getAutoBaseByAutoBaseId(autoBaseId);
        AutoBaseDto autoBaseDto= mapper.autoBaseToAutoBaseDto(autoBase);
        return autoBaseDto;
     }


    @Override
    @Transactional
    public synchronized AutoBase save(AutoBaseDto autoBaseDto) {
        AutoBase autoBase =mapper.autoBaseDtoToAutoBase(autoBaseDto);
        return dao.save(autoBase);
    }
    /*   @Override
    public List<AutoBase> getAll() {
        List<AutoBase> autoBases = dao.findAll();
        return autoBases;
    }*/


    // @Override
    //public List<AutoBaseDto> getAll() {
    //  List<AutoBase> autoBases = dao.findAll();
    //List<AutoBaseDto> autoBaseDtos = new ArrayList<>();
    //autoBases.forEach(autoBase -> {
    //  AutoBaseDto autoBaseDto = mapper.autoBaseToAutoBaseDto(autoBase);
    // autoBaseDtos.add(autoBaseDto);
    //});
    // return autoBaseDtos;
    //   }
}
