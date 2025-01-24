package com.generic.MartialManager.services;

import com.generic.MartialManager.Exceptions.StudentNotFoundException;
import com.generic.MartialManager.models.StudentModel;
import com.generic.MartialManager.repositories.StudentEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentEventService {

    @Autowired
    private StudentEventRepository studentEventRepository;

    @Autowired
    private StudentService studentService;

}
