package com.generic.MartialManager.models;

import com.generic.MartialManager.dtos.studentDtos.StudentCreateDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int belt;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    private LocalDate initialDate;

    public StudentModel(StudentCreateDTO studentCreateDTO){
        name = studentCreateDTO.name();
        age = studentCreateDTO.age();
        belt = studentCreateDTO.belt();
        email = studentCreateDTO.email();
        phoneNumber = studentCreateDTO.phoneNumber();
        initialDate = studentCreateDTO.initialDate();
    }
}
