package com.example.profile.application.service;

import com.example.profile.application.model.PetRequest;
import com.example.profile.application.model.PetResponse;

public interface PetServiceClient {
    String PET_SERVICE_PATH = "/pet-service/get-pet";

    public PetResponse getPet(PetRequest petRequest);
}
