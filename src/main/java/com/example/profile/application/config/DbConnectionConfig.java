package com.example.profile.application.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableConfigurationProperties(DbPropertiesConfig.class)
@RequiredArgsConstructor
public class DbConnectionConfig {

    private final DbPropertiesConfig dbPropertiesConfig;
    
    @Bean
    @Profile("dev")
    public String devDBConnection() {
        System.out.println("DEV Connection");
        System.out.println(dbPropertiesConfig.getUrl());
        System.out.println(dbPropertiesConfig.getDriverClassName());
        System.out.println(dbPropertiesConfig.getUserName());
        return "DEV Connection";
    }

}
