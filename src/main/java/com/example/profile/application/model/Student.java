package com.example.profile.application.model;


import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Value
@Jacksonized
public class Student {
    String name;
    String city;
    String title;
    Integer age;
    List<Integer> scores;
}
