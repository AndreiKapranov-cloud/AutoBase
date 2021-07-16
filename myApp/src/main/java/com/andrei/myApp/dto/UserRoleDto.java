package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Auto;
import com.andrei.myApp.model.entity.Trip;
import com.andrei.myApp.model.entity.UserRoleId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;
@Getter
@Setter
public class UserRoleDto {
    private Long userId;
    private Long roleId;
    private AutoDto auto;
    private List<TripDto> trips;
}
