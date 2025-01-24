package com.generic.MartialManager.dtos;

import com.generic.MartialManager.models.StudentModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDTO {

    private long id;

    private String name;

    private int age;

    private int belt;

    private String email;

    private String phoneNumber;

    private LocalDate initialDate;


    public StudentDTO(StudentModel studentModel) {
        BeanUtils.copyProperties(studentModel, this);
    }
}

