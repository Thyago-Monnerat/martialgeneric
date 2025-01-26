package com.generic.MartialManager.mappers;

import com.generic.MartialManager.dtos.eventDtos.EventDTO;
import com.generic.MartialManager.dtos.studentDtos.StudentDTO;
import com.generic.MartialManager.models.EventModel;
import com.generic.MartialManager.models.RegistrationModel;
import com.generic.MartialManager.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EventMapper eventMapper;

    public RegistrationModel fromDtoToModel(final StudentDTO studentDTO, final EventDTO eventDTO){

        StudentModel studentModel = studentMapper.fromDTOtoModel(studentDTO);
        EventModel eventModel = eventMapper.fromDtoToModel(eventDTO);


        return new RegistrationModel(studentModel, eventModel);
    }
}
