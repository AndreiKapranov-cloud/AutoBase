package com.andrei.myApp.service.converter;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.UserRole;
import com.andrei.myApp.service.serviceInterfaces.AutoBaseService;
import com.andrei.myApp.service.serviceInterfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/*@Component
public class StringToUserRoleDtoConverter implements Converter<String, UserRoleDto> {

    @Autowired
    private UserRoleService userRoleService;
final String str="UserRoleDto.role";
UserRole
    @Override
    public UserRoleDto convert(final String source){
        return userRoleService.getUserRoleByRole(Long.valueOf());
    }
}*/


