package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestUserDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
    private String createDate;
    private String secondName;
    private String userStatus;
    private String login;
    private String role;
    private String auto;
    private List<TripDto> dispatchersTrips;
    private List<TripDto> driversTrips;
}
