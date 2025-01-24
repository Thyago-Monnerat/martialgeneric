package com.generic.MartialManager.repositories;

import com.generic.MartialManager.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {


}
