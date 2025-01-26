package com.generic.MartialManager.repositories;

import com.generic.MartialManager.models.RegistrationModel;
import com.generic.MartialManager.models.RegistrationPkModel;
import com.generic.MartialManager.projections.RegistrationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<RegistrationModel, RegistrationPkModel> {
    @Query(nativeQuery = true, value = """
            SELECT s.name, e.title
            FROM tb_registration se
            JOIN tb_students s ON s.id = se.student_id
            JOIN tb_events e ON e.id = se.event_id ORDER BY s.id 
            """)
    List<RegistrationProjection> getAllRegistration();

    @Query(nativeQuery = true, value = """
            SELECT s.name, e.title
            FROM tb_registration se
            JOIN tb_students s ON s.id = se.student_id
            JOIN tb_events e ON e.id = se.event_id
            WHERE s.id = :id
            
        """)
    List<RegistrationProjection> getRegistrationByStudentId(long id);

    boolean existsByStudentId(long id);

    boolean existsByStudentIdAndEventId(long studentId, long eventId);
}
