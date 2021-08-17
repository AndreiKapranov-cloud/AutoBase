package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.AutoDto;
import com.andrei.myapp.model.dao.AutoDao;
import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.service.interfaces.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoDao dao;

    @Override
    public List<Auto> getAll() {
        List<Auto> autos = dao.findAll();
        return autos;
    }

    @Override
    public Auto getAutoByAutoId(Long autoId) {
        Auto auto = dao.getAutoByAutoId(autoId);
        return auto;
    }

    @Override
    public Auto getAutoByNumber(String number) {
        Auto auto = dao.getAutoByNumber(number);
        return auto;
    }
}