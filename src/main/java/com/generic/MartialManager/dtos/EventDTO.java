package com.generic.MartialManager.dtos;

import com.generic.MartialManager.models.EventModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalTime;

@Data
public class EventDTO {

    private long id;

    private String title;

    private String date;

    private String description;

    private String local;

    private LocalTime hours;

    public EventDTO(EventModel eventModel) {
        BeanUtils.copyProperties(eventModel, this);
    }
}
