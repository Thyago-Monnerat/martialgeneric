package com.generic.MartialManager.controllers;

import com.generic.MartialManager.dtos.eventDtos.EventCreateDTO;
import com.generic.MartialManager.dtos.eventDtos.EventDTO;
import com.generic.MartialManager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create")
    public ResponseEntity<String> createEvent(@RequestBody EventCreateDTO eventCreateDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventCreateDTO));
    }

    @PatchMapping("update")
    public ResponseEntity<String> updateEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(eventDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable long id){
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }
}
