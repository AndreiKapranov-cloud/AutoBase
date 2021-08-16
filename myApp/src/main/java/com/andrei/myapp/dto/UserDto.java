package com.andrei.myapp.dto;

import com.andrei.myapp.model.enums.UserEnum;
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
    private String login;
    private RoleDto role;
    private AutoDto auto;
    private List<TripDto> dispatchersTrips;
    private List<TripDto> driversTrips;
    private String userStatus;
}


