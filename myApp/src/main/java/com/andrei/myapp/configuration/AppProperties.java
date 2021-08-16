package com.andrei.myapp.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "map.google")
@Data
@Component
public class AppProperties {
    private String url;
}


