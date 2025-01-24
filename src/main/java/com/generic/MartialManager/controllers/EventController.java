package com.generic.MartialManager.controllers;

import com.generic.MartialManager.dtos.EventDTO;
import com.generic.MartialManager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("get/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable long id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<EventDTO>> getEvents() {
        return ResponseEntity.ok(eventService.getEvents());
    }
}
