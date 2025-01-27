package com.generic.MartialManager.services;

import com.generic.MartialManager.exceptions.DataNotFoundException;
import com.generic.MartialManager.dtos.studentDtos.StudentCreateDTO;
import com.generic.MartialManager.dtos.studentDtos.StudentDTO;
import com.generic.MartialManager.mappers.StudentMapper;
import com.generic.MartialManager.models.StudentModel;
import com.generic.MartialManager.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.generic.MartialManager.utils.ValidatorUtil.hasEspecialChar;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Transactional(readOnly = true)
    public StudentDTO getStudent(long id) {
        StudentModel student = studentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Aluno não encontrado!"));

        return new StudentDTO(student);
    }

    @Transactional(readOnly = true)
    public List<StudentDTO> getStudents() {
        List<StudentModel> studentList = studentRepository.findAll();

        return studentList.stream().map(StudentDTO::new).toList();
    }

    @Transactional
    public String createStudent(StudentCreateDTO studentCreateDTO) {
        hasEspecialChar(studentCreateDTO.name());

        studentRepository.save(studentMapper.fromCreateDtoToModel(studentCreateDTO));

        return "Aluno " + studentCreateDTO.name() + " criado com sucesso!";
    }

    @Transactional
    public String updateStudent(long id, StudentCreateDTO studentCreateDTO) {

        StudentModel student = studentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Aluno não encontrado"));

        hasEspecialChar(studentCreateDTO.name());

        student.setName(studentCreateDTO.name());
        student.setAge(studentCreateDTO.age());
        student.setEmail(studentCreateDTO.email());
        student.setPhoneNumber(studentCreateDTO.phoneNumber());
        student.setInitialDate(studentCreateDTO.initialDate());

        return "Aluno " + student.getName() + " atualizado!";
    }

    @Transactional
    public String deleteStudent(long id) {
        StudentModel student = studentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Aluno não encontrado!"));

        studentRepository.delete(student);

        return "Aluno " + student.getName() + " deletado!";
    }
}
