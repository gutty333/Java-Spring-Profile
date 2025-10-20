package com.example.profile.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
@ConfigurationProperties(prefix = "spring.client")
public class RestClientConfig {
    int connectionTimeout;
    int readTimeout;

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        System.out.println("Creating the rest client");
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);

        return builder
                .requestFactory(factory)
                .build();
    }
}

