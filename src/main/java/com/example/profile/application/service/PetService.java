package com.example.profile.application.service;

import com.example.profile.application.config.PetServicePropertiesConfig;
import com.example.profile.application.model.PetRequest;
import com.example.profile.application.model.PetResponse;
import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.profile.application.model.enums.PetAction.EXPLORE;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PetService implements PetServiceClient {

    PetServicePropertiesConfig petServicePropertiesConfig;

    RestClient restClient;

    private static PetResponse mockPetResponse() {
        Faker faker = new Faker();

        return PetResponse.builder()
                .petDetails(List.of(PetResponse.PetDetails.builder()
                        .name(faker.name().firstName() + " the DOG")
                        .action(EXPLORE)
                        .date(LocalDate.now())
                        .petLocation(
                                PetResponse.PetLocation.builder()
                                        .country(faker.country().name())
                                        .address(faker.address().fullAddress())
                                        .build()
                        )
                        .build()))
                .build();
    }

    @Override
    public PetResponse getPet(PetRequest request) {
        Boolean serviceFlag = Optional.ofNullable(petServicePropertiesConfig.getEnabled())
                .orElse(false);

        if (serviceFlag) {
            String path = petServicePropertiesConfig.getEndpoint() + PET_SERVICE_PATH;

            try {
                log.info("The body is {}", request);
                return restClient.post()
                        .uri(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(request)
                        .retrieve()
                        .body(PetResponse.class);
            } catch (RestClientException e) {
                log.error("Client call failed", e);
                return mockPetResponse();
            }
        } else {
            return mockPetResponse();
        }

    }
}
