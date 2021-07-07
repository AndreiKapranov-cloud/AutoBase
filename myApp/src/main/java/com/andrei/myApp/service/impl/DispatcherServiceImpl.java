package com.andrei.myApp.service.impl;

import com.andrei.myApp.mapper.DispatcherDispatcherDtoMapper;
import com.andrei.myApp.dto.DispatcherDto;
import com.andrei.myApp.model.dao.DispatcherDao;
import com.andrei.myApp.model.entity.Dispatcher;
import com.andrei.myApp.service.serviceInterfaces.DispatcherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DispatcherServiceImpl implements DispatcherService {
    private final DispatcherDao dao;
    private final DispatcherDispatcherDtoMapper mapper;
    public DispatcherServiceImpl(DispatcherDao dao, DispatcherDispatcherDtoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }


    @Override
    public List<DispatcherDto> getAll() {
        List<Dispatcher> dispatchers = dao.findAll();
        List<DispatcherDto> dispatcherDtos = new ArrayList<>();
        dispatchers.forEach(dispatcher -> {
            DispatcherDto dispatcherDto = mapper.dispatcherToDispatcherDto(dispatcher);
            dispatcherDtos.add(dispatcherDto);
        });
        return dispatcherDtos;
    }

    @Override
    public Dispatcher save(DispatcherDto dispatcherDto) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher =mapper.dispatcherDtoToDispatcher(dispatcherDto);
        return dao.save(dispatcher);
    }

}
