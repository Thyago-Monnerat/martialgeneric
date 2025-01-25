package com.generic.MartialManager.dtos.eventDtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventCreateDTO {

    private String title;

    private LocalDate date;

    private String description;

    private String local;

    private LocalTime hours;
}
