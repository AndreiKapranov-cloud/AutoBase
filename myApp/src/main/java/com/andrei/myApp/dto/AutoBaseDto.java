package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Trip;
import com.andrei.myApp.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class AutoBaseDto {
    private Long autoBaseId;
    private String address;
    private String nameOfOrganization;
    private List<TripDto> trips;
    private List<UserDto>users;


}
