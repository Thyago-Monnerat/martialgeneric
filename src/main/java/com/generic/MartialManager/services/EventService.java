package com.generic.MartialManager.services;

import com.generic.MartialManager.exceptions.DataNotFoundException;
import com.generic.MartialManager.dtos.eventDtos.EventCreateDTO;
import com.generic.MartialManager.dtos.eventDtos.EventDTO;
import com.generic.MartialManager.mappers.EventMapper;
import com.generic.MartialManager.models.EventModel;
import com.generic.MartialManager.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.generic.MartialManager.utils.ValidatorUtil.hasEspecialChar;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    @Transactional(readOnly = true)
    public EventDTO getEvent(long id) {
        EventModel eventModel = eventRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Evento não encontrado!"));

        return new EventDTO(eventModel);
    }

    @Transactional(readOnly = true)
    public List<EventDTO> getEvents() {
        List<EventModel> list = eventRepository.findAll();

        return list.stream().map(EventDTO::new).toList();
    }

    @Transactional
    public String createEvent(EventCreateDTO eventCreateDTO) {
        hasEspecialChar(eventCreateDTO.getTitle());

        eventRepository.save(eventMapper.fromCreateDtoToModel(eventCreateDTO));

        return "Evento: " + eventCreateDTO.getTitle() + " salvo com sucesso!";
    }

    @Transactional
    public String updateEvent(EventDTO eventDTO) {
        hasEspecialChar(eventDTO.getTitle());

        EventModel eventModel = eventRepository.findById(eventDTO.getId()).orElseThrow(() -> new DataNotFoundException("Evento não encontrado!"));

        eventModel.setTitle(eventDTO.getTitle());
        eventModel.setDescription(eventDTO.getDescription());
        eventModel.setDate(eventDTO.getDate());
        eventModel.setHours(eventDTO.getHours());
        eventModel.setLocal(eventDTO.getLocal());

        return "Evento " + eventModel.getTitle() + " Salvo com sucesso!";
    }


    @Transactional
    public String deleteEvent(long id) {

        EventModel eventModel = eventRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Evento não encontrado!"));

        eventRepository.deleteById(id);

        return "Evento " + eventModel.getTitle() + " deletado com sucesso!";
    }


}
