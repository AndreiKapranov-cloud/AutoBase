package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Order;
import com.andrei.myApp.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
public class DispatcherDto {

    private Long dispatcherId;
    private String dispatcherName;
    private String dispatcherSecondName;
    private List<TripDto> tripDtos;
    private List<OrderDto> orderDtos;
}
