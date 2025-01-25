package com.generic.MartialManager.models;

import com.generic.MartialManager.dtos.eventDtos.EventCreateDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_events")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate date;

    private String description;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private LocalTime hours;

    public EventModel(EventCreateDTO eventCreateDTO) {
        BeanUtils.copyProperties(eventCreateDTO, this);
    }
}
