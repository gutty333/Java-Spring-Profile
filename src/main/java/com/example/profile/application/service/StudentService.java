package com.example.profile.application.service;

import com.example.profile.application.model.Student;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
@Slf4j
@RequiredArgsConstructor
@ConfigurationProperties(value = "spring.application.name")
public class StudentService {

    String title;

    public Student createStudent(Environment environment, String corporateName) {
        Faker faker = new Faker();
        Random random = new Random();

        return Student.builder()
                .name(faker.name().fullName())
                .city(faker.country().name())
                .age(faker.number().numberBetween(18, 35))
                .title(String.join("", environment.getActiveProfiles()).toUpperCase() + " " + corporateName)
                .scores(IntStream.range(1, 10)
                        .boxed()
                        .map(num -> num * random.nextInt(1, 102))
                        .filter(num -> num % 2 == 0)
                        .toList())
                .build();
    }
}
