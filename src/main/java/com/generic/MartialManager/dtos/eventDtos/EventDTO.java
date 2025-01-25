package com.generic.MartialManager.dtos.eventDtos;

import com.generic.MartialManager.models.EventModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class EventDTO {

    private long id;

    private String title;

    private LocalDate date;

    private String description;

    private String local;

    private LocalTime hours;

    public EventDTO(EventModel eventModel) {
        BeanUtils.copyProperties(eventModel, this);
    }
}
