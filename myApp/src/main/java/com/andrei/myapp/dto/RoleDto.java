package com.andrei.myapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDto {
    private Long roleId;
    private String rolEnum;
    private List<UserDto>users;
}
