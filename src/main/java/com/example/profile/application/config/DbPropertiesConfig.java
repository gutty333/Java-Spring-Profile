package com.example.profile.application.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.datasource")
public class DbPropertiesConfig {
    String url;
    String driverClassName;
    String userName;
    String password;
}
