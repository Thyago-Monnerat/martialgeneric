package com.generic.MartialManager.services;

import com.generic.MartialManager.projections.RegistrationProjection;
import com.generic.MartialManager.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Transactional
    public List<RegistrationProjection> getAllStudentEvent(){
        return registrationRepository.getAllStudentsEvents();
    }
}
