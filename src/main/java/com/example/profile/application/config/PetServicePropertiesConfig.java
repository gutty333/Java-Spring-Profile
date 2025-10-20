package com.example.profile.application.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.pet-service")
@Getter
@Setter
public class PetServicePropertiesConfig {
    Boolean enabled;
    String endpoint;
}
