package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
public class TripDto {
    private Long tripId;
    private int distanceKm;
    private AutoBaseDto autoBase;
    private OrdersDto orders;
    private List<UserRoleDto> userRoles;
}
