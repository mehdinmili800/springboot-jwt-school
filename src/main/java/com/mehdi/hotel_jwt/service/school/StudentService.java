package com.mehdi.hotel_jwt.service.school;

import com.mehdi.hotel_jwt.entity.school.Student;
import com.mehdi.hotel_jwt.repository.school.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public StudentService(StudentRepository schoolRepository, BCryptPasswordEncoder passwordEncoder) {
        this.studentRepository = schoolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Student createStudent(Student student){
        String hashedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(hashedPassword);
        return studentRepository.save(student);
    }

    public Student getStudentByUsername(String username){
        return studentRepository.findByUsername(username);
    }

    public boolean authenticateUser(String username , String password){
        Student student = getStudentByUsername(username);
        return student != null && student.getPassword().equals(password);
    }
}
