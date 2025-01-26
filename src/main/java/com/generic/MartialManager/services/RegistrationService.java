package com.generic.MartialManager.services;

import com.generic.MartialManager.exceptions.DataNotFoundException;
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

    @Transactional(readOnly = true)
    public List<RegistrationProjection> getAllRegistration(){
        return registrationRepository.getAllRegistration();
    }

    @Transactional(readOnly = true)
    public List<RegistrationProjection> getRegistration(long id){

        if(!registrationRepository.existsByStudentId(id)){
            throw new DataNotFoundException("Nenhum evento associado ao id do aluno requisitado!");
        }

        return registrationRepository.getRegistrationByStudentId(id);
    }
}
