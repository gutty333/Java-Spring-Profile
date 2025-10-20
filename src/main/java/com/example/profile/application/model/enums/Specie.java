package com.example.profile.application.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Specie {
    DOG("0"),
    CAT("1"),
    LIZARD("2"),
    RODENT("3");

    @Getter(onMethod_ = @JsonValue)
    final String speciesCode;
}
