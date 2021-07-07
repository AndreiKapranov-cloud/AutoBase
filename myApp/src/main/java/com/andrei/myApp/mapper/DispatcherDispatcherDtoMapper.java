package com.andrei.myApp.mapper;

import com.andrei.myApp.dto.DispatcherDto;
import com.andrei.myApp.model.entity.Dispatcher;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface DispatcherDispatcherDtoMapper {
DispatcherDto dispatcherToDispatcherDto(Dispatcher dispatcher);
Dispatcher dispatcherDtoToDispatcher(DispatcherDto dispatcherDto);
}
