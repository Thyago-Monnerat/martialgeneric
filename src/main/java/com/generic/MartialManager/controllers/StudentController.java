package com.generic.MartialManager.controllers;

import com.generic.MartialManager.dtos.studentDtos.StudentCreateDTO;
import com.generic.MartialManager.dtos.studentDtos.StudentDTO;
import com.generic.MartialManager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("get/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping("create")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreateDTO studentCreateDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentCreateDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @PatchMapping("update/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable long studentId, @RequestBody StudentCreateDTO studentCreateDTO) {
        return ResponseEntity.ok(studentService.updateStudent(studentId, studentCreateDTO));
    }

}
