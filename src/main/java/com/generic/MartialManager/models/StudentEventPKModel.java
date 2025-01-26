package com.generic.MartialManager.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class StudentEventPKModel {

    @ManyToOne()
    private StudentModel student;
    @ManyToOne()
    private EventModel event;

    public StudentEventPKModel(){}

    public StudentEventPKModel(StudentModel studentModel, EventModel eventModel){
        this.student = studentModel;
        this.event = eventModel;
    }
}