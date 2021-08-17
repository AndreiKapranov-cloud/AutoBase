package com.andrei.myapp.service.interfaces;

import com.andrei.myapp.dto.AutoDto;
import com.andrei.myapp.model.entity.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAll();
    Auto getAutoByAutoId(Long autoId);
    Auto getAutoByNumber(String number);
}
