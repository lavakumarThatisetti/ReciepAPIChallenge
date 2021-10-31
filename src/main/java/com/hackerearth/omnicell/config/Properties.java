package com.hackerearth.omnicell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "spring")
@Data
public class Properties {
    private Api api;

    @Data
    public static class Api {
        String recipeApi;
    }
}
