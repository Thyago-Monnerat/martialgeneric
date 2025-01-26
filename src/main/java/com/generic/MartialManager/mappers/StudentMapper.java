package com.generic.MartialManager.mappers;

import com.generic.MartialManager.dtos.studentDtos.StudentCreateDTO;
import com.generic.MartialManager.dtos.studentDtos.StudentDTO;
import com.generic.MartialManager.models.StudentModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentModel fromDTOtoModel(final StudentDTO studentDTO) {

        StudentModel studentModel = new StudentModel();

        BeanUtils.copyProperties(studentDTO, studentModel);

        return studentModel;
    }

    public StudentDTO fromModelToDTO(final StudentModel studentModel) {
        StudentDTO studentDTO = new StudentDTO();

        BeanUtils.copyProperties(studentModel, studentDTO);

        return studentDTO;
    }

    public StudentModel fromCreateDTOtoModel(final StudentCreateDTO studentCreateDTO){

        StudentModel studentModel = new StudentModel();

        studentModel.setName(studentCreateDTO.name());
        studentModel.setAge(studentCreateDTO.age());
        studentModel.setBelt(studentCreateDTO.belt());
        studentModel.setEmail(studentCreateDTO.email());
        studentModel.setPhoneNumber(studentCreateDTO.phoneNumber());
        studentModel.setInitialDate(studentCreateDTO.initialDate());

        return studentModel;
    }
}
