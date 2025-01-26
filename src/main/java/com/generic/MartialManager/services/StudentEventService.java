package com.generic.MartialManager.services;

import com.generic.MartialManager.projections.StudentEventProjection;
import com.generic.MartialManager.repositories.StudentEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentEventService {

    @Autowired
    private StudentEventRepository studentEventRepository;

    @Transactional
    public List<StudentEventProjection> getAllStudentEvent(){
        return studentEventRepository.getAllStudentsEvents();
    }
}
