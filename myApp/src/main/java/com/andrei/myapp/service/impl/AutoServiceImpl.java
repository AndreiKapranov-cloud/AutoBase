package com.andrei.myapp.service.impl;

import com.andrei.myapp.model.dao.AutoDao;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.service.interfaces.AutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {
    private final AutoDao dao;

    public AutoServiceImpl(AutoDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Auto> getAll() {
       List<Auto>autos=dao.findAll();
        return autos;
    }

    @Override
    public Auto getAutoByAutoId(Long autoId) {
       Auto auto = dao.getAutoByAutoId(autoId);
        return auto;
    }
}