package com.example.profile.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    String mockProxy() {
        return "Calling the Mock proxy bean";
    }

    @Bean
    String realProxy() {
        return "Calling the Real proxy bean";
    }

    @Bean
    String currentBean() {
        return "The original current bean";
    }

}
