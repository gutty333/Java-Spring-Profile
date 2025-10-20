package com.example.profile.application.model;

import com.example.profile.application.model.enums.PetAction;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.List;

@Value
@Jacksonized
@Builder
public class PetResponse {
    List<PetDetails> petDetails;

    @Value
    @Jacksonized
    @Builder
    public static class PetDetails {
        PetAction action;
        LocalDate date;
        String name;
        PetLocation petLocation;
    }

    @Value
    @Jacksonized
    @Builder
    public static class PetLocation {
        String country;
        String address;
    }
}
