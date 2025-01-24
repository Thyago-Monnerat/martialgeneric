package com.generic.MartialManager.services;

import com.generic.MartialManager.Exceptions.StudentNotFoundException;
import com.generic.MartialManager.dtos.StudentCreateDTO;
import com.generic.MartialManager.dtos.StudentDTO;
import com.generic.MartialManager.models.StudentModel;
import com.generic.MartialManager.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public StudentDTO get(long id) {
        StudentModel student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Aluno não encontrado!"));

        return new StudentDTO(student);
    }

    @Transactional
    public StudentModel getStudentModelById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Aluno não encontrado!"));
    }

    @Transactional(readOnly = true)
    public List<StudentDTO> getAll() {
        List<StudentModel> studentList = studentRepository.findAll();

        return studentList.stream().map(StudentDTO::new).toList();
    }

    @Transactional
    public StudentCreateDTO add(StudentCreateDTO studentCreateDTO) {
        studentRepository.save(new StudentModel(studentCreateDTO));

        return studentCreateDTO;
    }

    @Transactional
    public String updateStudent(StudentDTO studentDTO) {

        StudentModel student = studentRepository.findById(studentDTO.getId()).orElseThrow(() -> new StudentNotFoundException("Aluno não encontrado"));

        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setInitialDate(studentDTO.getInitialDate());

        return "Aluno " + student.getName() + " atualizado!";
    }

    @Transactional
    public String delete(long id) {
        StudentModel student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Aluno não encontrado!"));

        studentRepository.delete(student);

        return "Aluno " + student.getName() + " deletado!";
    }
}
