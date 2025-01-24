package com.generic.MartialManager.controllers;

import com.generic.MartialManager.dtos.StudentCreateDTO;
import com.generic.MartialManager.dtos.StudentDTO;
import com.generic.MartialManager.dtos.StudentUpdateDTO;
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
        return ResponseEntity.ok(studentService.get(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<StudentCreateDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }


    @PostMapping("create")
    public ResponseEntity<StudentCreateDTO> createStudent(@RequestBody StudentCreateDTO studentCreateDTO) {
        return ResponseEntity.ok(studentService.add(studentCreateDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable long id, @RequestBody StudentUpdateDTO studentUpdateDTO)  {
        studentService.updateStudent(id, studentUpdateDTO);
        return ResponseEntity.ok("Updated!");
    }

}
