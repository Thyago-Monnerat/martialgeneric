package com.generic.MartialManager.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class RegistrationPkModel {

    @ManyToOne()
    private StudentModel student;
    @ManyToOne()
    private EventModel event;

    public RegistrationPkModel(StudentModel studentModel, EventModel eventModel){
        this.student = studentModel;
        this.event = eventModel;
    }
}