package com.generic.MartialManager.models;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;


@Data
@Entity
@Table(name = "tb_student_event")
public class StudentEventModel {

    @EmbeddedId
    private StudentEventPKModel id = new StudentEventPKModel();

    public StudentEventModel() {
    }

    public StudentEventModel(StudentModel studentModel, EventModel eventModel) {
        id.setStudent(studentModel);
        id.setEvent(eventModel);
    }

}

@Embeddable
@Data
class StudentEventPKModel {

    @ManyToOne
    private StudentModel student;
    @ManyToOne
    private EventModel event;

    public StudentEventPKModel(){}

    public StudentEventPKModel(StudentModel studentModel, EventModel eventModel){
        this.student = studentModel;
        this.event = eventModel;
    }
}
