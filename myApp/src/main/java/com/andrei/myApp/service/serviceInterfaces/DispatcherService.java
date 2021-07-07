package com.andrei.myApp.service.serviceInterfaces;

import com.andrei.myApp.dto.DispatcherDto;
import com.andrei.myApp.model.entity.Dispatcher;

import java.util.List;

public interface DispatcherService {
    List<DispatcherDto> getAll();
    Dispatcher save(DispatcherDto dispatcherDto);
}
