package com.generic.MartialManager.mappers;

import com.generic.MartialManager.dtos.eventDtos.EventCreateDTO;
import com.generic.MartialManager.dtos.eventDtos.EventDTO;
import com.generic.MartialManager.models.EventModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventModel fromCreateDtoToModel(EventCreateDTO eventCreateDTO){

        EventModel eventModel = new EventModel();

        eventModel.setTitle(eventCreateDTO.getTitle());
        eventModel.setDescription(eventCreateDTO.getDescription());
        eventModel.setDate(eventCreateDTO.getDate());
        eventModel.setLocal(eventCreateDTO.getLocal());
        eventModel.setHours(eventCreateDTO.getHours());

        return eventModel;

    }

    public EventModel fromDtoToModel(EventDTO eventDTO){
        EventModel eventModel = new EventModel();

        BeanUtils.copyProperties(eventDTO, eventModel);

        return eventModel;
    }
}
