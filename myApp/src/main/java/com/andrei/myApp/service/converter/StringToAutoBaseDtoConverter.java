package com.andrei.myApp.service.converter;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.model.entity.AutoBase;
import com.andrei.myApp.service.serviceInterfaces.AutoBaseService;
import com.andrei.myApp.service.serviceInterfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/*@Component
public class StringToAutoBaseDtoConverter implements Converter<String, AutoBaseDto> {

    @Autowired
    private AutoBaseService autoBaseService;

    @Override
    public AutoBaseDto convert() {
        return autoBaseService.getAutoBaseByNameOfOrganization(nameOfOrganization);
    }
}*/