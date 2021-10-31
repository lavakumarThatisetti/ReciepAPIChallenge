package com.hackerearth.omnicell.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${spring.application.description}")
    private String appDescription = null;

    @Value("${spring.application.name}")
    private String appName =  null;

    @Value("${spring.application.version}")
    private String appVersion =  null;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title(appName)
                .version(appVersion)
                .description(appDescription));
    }
}
