package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.model.entity.Trip;
import lombok.Getter;
import lombok.Setter;

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
    private List<RoleDto> roles;
    private Boolean ready;

}


