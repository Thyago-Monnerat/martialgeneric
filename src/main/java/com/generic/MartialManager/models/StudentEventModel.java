package com.generic.MartialManager.models;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@Entity
@Table(name = "tb_student_event")
public class StudentEventModel {

    @EmbeddedId
    private StudentEventPKModel id = new StudentEventPKModel();

    @ManyToOne()
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentModel student;

    @ManyToOne()
    @JoinColumn(name = "event_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EventModel event;

    public StudentEventModel() {
    }

    public StudentEventModel(StudentModel studentModel, EventModel eventModel) {
        id.setStudent(studentModel);
        id.setEvent(eventModel);
    }

}
