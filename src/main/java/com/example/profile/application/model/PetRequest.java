package com.example.profile.application.model;


import com.example.profile.application.model.enums.PetAction;
import com.example.profile.application.model.enums.Specie;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
@Jacksonized
public class PetRequest {
    @JsonProperty("request_action")
    PetAction requestAction;
    LocalDate requestDate;
    List<Pet> pets;

    @Value
    @Builder
    public static class Pet {
        String name;
        Specie specie;
        Integer age;
        List<String> friends;
    }
}