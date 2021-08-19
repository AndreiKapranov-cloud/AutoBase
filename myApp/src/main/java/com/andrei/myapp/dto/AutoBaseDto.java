package com.andrei.myapp.dto;

import com.andrei.myapp.model.entity.Orders;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class AutoBaseDto {
    private Long autoBaseId;
    private String address;
    private String nameOfOrganization;
    private List<Orders>orders;

}
