package com.andrei.myApp.dto;

import com.andrei.myApp.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDto {
    private Long roleId;
    private String role;
    private List<UserDto>users;
}
