package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Dispatcher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private Time termOfDelivery;
    private int weight;
    private String deliveryAddress;
    private DispatcherDto dispatcherDto;

}
