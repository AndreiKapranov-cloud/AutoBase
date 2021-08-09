package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
    private Date createDate;
    private String secondName;
    private Boolean ready;
    private RoleDto role;
    private List<AutoDto>autos;
    private List<TripDto> dispatchersTrips;
    private List<TripDto> driversTrips;
}


