package com.generic.MartialManager.controllers;

import com.generic.MartialManager.dtos.registrationDTO.RegistrationDTO;
import com.generic.MartialManager.projections.RegistrationProjection;
import com.generic.MartialManager.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("getAll")
    public ResponseEntity<List<RegistrationProjection>> getAllStudentsEvents() {
        return ResponseEntity.ok(registrationService.getAllRegistration());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<RegistrationProjection>> getAllStudentsEvents(@PathVariable long id) {
        return ResponseEntity.ok(registrationService.getRegistration(id));
    }

    @PostMapping("create")
    public ResponseEntity<String> createRegistration(@RequestBody RegistrationDTO registrationDTO) {
        return ResponseEntity.ok(registrationService.createRegistration(registrationDTO));
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteRegistration(@RequestBody RegistrationDTO registrationDTO) {
        return ResponseEntity.ok(registrationService.deleteRegistration(registrationDTO));
    }
}
