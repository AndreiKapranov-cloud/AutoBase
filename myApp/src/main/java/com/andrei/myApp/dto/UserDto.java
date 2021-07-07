package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.AutoBase;
import com.andrei.myApp.model.entity.Trip;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
    private String createTime;
    private UserRoleDto userRole;
    private AutoBaseDto autoBase;


}


