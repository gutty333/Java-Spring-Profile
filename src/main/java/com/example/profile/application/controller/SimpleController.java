package com.example.profile.application.controller;

import com.example.profile.application.config.PropertiesConfig;
import com.example.profile.application.model.PetRequest;
import com.example.profile.application.model.PetResponse;
import com.example.profile.application.model.Student;
import com.example.profile.application.service.PetService;
import com.example.profile.application.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intro")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SimpleController {

    StudentService studentService;

    Environment environment;

    PropertiesConfig propertiesConfig;

    PetService petService;

    @GetMapping
    public ResponseEntity<Student> getIntro() {
        return ResponseEntity.ok(studentService.createStudent(environment, propertiesConfig.getName()));
    }

    @PostMapping("/explore-pets")
    public ResponseEntity<PetResponse> explorePets(@RequestBody PetRequest request) {
        return ResponseEntity.ok(petService.getPet(request));
    }
}
