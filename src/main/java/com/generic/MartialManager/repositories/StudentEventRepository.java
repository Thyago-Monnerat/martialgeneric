package com.generic.MartialManager.repositories;

import com.generic.MartialManager.models.StudentEventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentEventRepository extends JpaRepository<StudentEventModel, Long> {
    @Modifying
    @Query(nativeQuery = true,
            value = "DELETE FROM tb_student_event WHERE student_id = :id")
    void deleteByStudentId(long id);

    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO tb_student_event (student_id, event_id) VALUES (:student_id, :event_id)")
    void addStudentEventRelation(long student_id, long event_id);
}
