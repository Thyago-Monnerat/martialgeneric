package com.generic.MartialManager.services;

import com.generic.MartialManager.Exceptions.FieldNotFoundException;
import com.generic.MartialManager.Exceptions.NotAcceptableException;
import com.generic.MartialManager.Exceptions.StudentNotFoundException;
import com.generic.MartialManager.dtos.StudentCreateDTO;
import com.generic.MartialManager.dtos.StudentDTO;
import com.generic.MartialManager.dtos.StudentUpdateDTO;
import com.generic.MartialManager.models.StudentModel;
import com.generic.MartialManager.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public StudentDTO get(long id) {
        Optional<StudentModel> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return new StudentDTO(
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getBelt(),
                    student.get().getEmail(),
                    student.get().getPhoneNumber(),
                    student.get().getInitialDate()
            );
        } else {
            throw new StudentNotFoundException("Aluno não encontrado!");
        }
    }

    @Transactional
    public Optional<StudentModel> getStudentModelById(long id) {
        return studentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<StudentCreateDTO> getAll() {
        List<StudentModel> studentList = studentRepository.findAll();

        return studentList.stream()
                .map(student -> new StudentCreateDTO(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getBelt(),
                        student.getEmail(),
                        student.getPhoneNumber(),
                        student.getInitialDate()
                ))
                .toList();
    }

    @Transactional
    public StudentCreateDTO add(StudentCreateDTO studentCreateDTO) {
        studentRepository.save(new StudentModel(studentCreateDTO));

        return studentCreateDTO;
    }

    @Transactional
    public void updateStudent(long id, StudentUpdateDTO studentUpdateDTO) {

        Optional<StudentModel> student = studentRepository.findById(id);

        if (student.isPresent()) {
            try {
                StudentModel studentModel = student.get();
                Field field = StudentModel.class.getDeclaredField(studentUpdateDTO.fieldName());

                field.setAccessible(true);

                if (field.getType().equals(String.class)) {
                    field.set(studentModel, studentUpdateDTO.newValue());
                } else if (field.getType().equals(int.class)) {
                    field.setInt(studentModel, Integer.parseInt(studentUpdateDTO.newValue()));
                } else if (field.getType().equals(LocalDate.class)) {
                    field.set(studentModel, LocalDate.parse(studentUpdateDTO.newValue()));
                }
                studentRepository.save(studentModel);
            } catch (NoSuchFieldException e) {
                throw new FieldNotFoundException("Campo não encontrado");
            } catch (IllegalAccessException e) {
                throw new NotAcceptableException("Acesso ilegal");
            }
        }else{
            throw new StudentNotFoundException("Aluno não encontrado!");
        }
    }

    @Transactional
    public String delete(long id) {
        studentRepository.deleteById(id);

        return "Deletado!";
    }
}
