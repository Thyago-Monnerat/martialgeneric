package com.generic.MartialManager.services;

import com.generic.MartialManager.dtos.eventDtos.EventDTO;
import com.generic.MartialManager.dtos.registrationDTO.RegistrationDTO;
import com.generic.MartialManager.dtos.studentDtos.StudentDTO;
import com.generic.MartialManager.exceptions.DataNotFoundException;
import com.generic.MartialManager.exceptions.DuplicateStudentEventRegistrationException;
import com.generic.MartialManager.mappers.RegistrationMapper;
import com.generic.MartialManager.models.RegistrationModel;
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

    @Autowired
    private StudentService studentService;

    @Autowired
    private EventService eventService;

    @Autowired
    private RegistrationMapper registrationMapper;

    @Transactional(readOnly = true)
    public List<RegistrationProjection> getAllRegistration() {
        return registrationRepository.getAllRegistration();
    }

    @Transactional(readOnly = true)
    public List<RegistrationProjection> getRegistration(long id) {

        if (!registrationRepository.existsByStudentId(id)) {
            throw new DataNotFoundException("Nenhum evento associado ao id do aluno requisitado!");
        }

        return registrationRepository.getRegistrationByStudentId(id);
    }

    @Transactional
    public String createRegistration(RegistrationDTO registrationDTO) {

        StudentDTO studentDTO = studentService.getStudent(registrationDTO.studentId());
        EventDTO eventDTO = (eventService.getEvent(registrationDTO.eventId()));

        if (registrationRepository.existsByStudentIdAndEventId(registrationDTO.studentId(), registrationDTO.eventId())) {
            throw new DuplicateStudentEventRegistrationException("Aluno " + studentDTO.getName() + " já está inscrito no evento " + eventDTO.getTitle());
        }

        RegistrationModel registrationModel = registrationMapper.fromDtoToModel(studentDTO, eventDTO);

        registrationRepository.save(registrationModel);

        return "Inscrição do aluno " + studentDTO.getName() + " no evento " + eventDTO.getTitle() + " criada com sucesso!";
    }

    @Transactional
    public String deleteRegistration(RegistrationDTO registrationDTO) {

        StudentDTO studentDTO = studentService.getStudent(registrationDTO.studentId());
        EventDTO eventDTO = (eventService.getEvent(registrationDTO.eventId()));

        if (!registrationRepository.existsByStudentIdAndEventId(registrationDTO.studentId(), registrationDTO.eventId())) {
            throw new DuplicateStudentEventRegistrationException("Aluno " + studentDTO.getName() + " não está inscrito no evento " + eventDTO.getTitle());
        }


        registrationRepository.deleteByStudentIdAndEventId(registrationDTO.studentId(), registrationDTO.eventId());

        return "Inscrição do aluno " + studentDTO.getName() + " no evento " + eventDTO.getTitle() + " cancelada com sucesso!";
    }
}
