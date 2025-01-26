package com.generic.MartialManager.models;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_registration ")
public class RegistrationModel {

    @EmbeddedId
    private RegistrationPkModel  id = new RegistrationPkModel();

    @ManyToOne()
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentModel student;

    @ManyToOne()
    @JoinColumn(name = "event_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EventModel event;

    public RegistrationModel(StudentModel studentModel, EventModel eventModel) {
        id.setStudent(studentModel);
        id.setEvent(eventModel);
    }

}
