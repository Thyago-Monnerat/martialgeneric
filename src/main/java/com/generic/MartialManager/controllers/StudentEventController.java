package com.generic.MartialManager.controllers;

import com.generic.MartialManager.projections.StudentEventProjection;
import com.generic.MartialManager.services.StudentEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("studentEvent")
public class StudentEventController {
    @Autowired
    private StudentEventService studentService;

    @GetMapping("getAll")
    public List<StudentEventProjection> getAllStudentsEvents(){
        return studentService.getAllStudentEvent();
    }
}
