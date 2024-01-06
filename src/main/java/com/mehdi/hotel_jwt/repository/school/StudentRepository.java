package com.mehdi.hotel_jwt.repository.school;

import com.mehdi.hotel_jwt.entity.school.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByUsername(String username);
}
