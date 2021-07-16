package com.andrei.myApp.service.converter;

import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*@Component
@EnableSpringDataWebSupport
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final StringToAutoDtoConverter stringToAutoDtoConverter;
    private final StringToAutoBaseDtoConverter stringToAutoBaseDtoConverter;

    public WebMvcConfig(StringToAutoBaseDtoConverter stringToAutoBaseDtoConverter, StringToAutoDtoConverter stringToAutoDtoConverter) {
        this.stringToAutoBaseDtoConverter = stringToAutoBaseDtoConverter;
        this.stringToAutoDtoConverter = stringToAutoDtoConverter;

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToAutoDtoConverter);
        registry.addConverter(stringToAutoBaseDtoConverter);
        super.addFormatters(registry);
    }

}*/



