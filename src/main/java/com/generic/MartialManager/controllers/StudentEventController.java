package com.generic.MartialManager.controllers;

import com.generic.MartialManager.projections.RegistrationProjection;
import com.generic.MartialManager.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("studentEvent")
public class StudentEventController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("getAll")
    public List<RegistrationProjection> getAllStudentsEvents(){
        return registrationService.getAllStudentEvent();
    }
}
