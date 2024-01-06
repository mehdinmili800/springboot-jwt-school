package com.mehdi.hotel_jwt.controller.school;

import com.mehdi.hotel_jwt.entity.school.Student;
import com.mehdi.hotel_jwt.service.school.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PostMapping("/login")
    public String login(@RequestBody Student student){
        String username = student.getUsername();
        String password = student.getPassword();

        if (studentService.authenticateUser(username, password)) {

            return "Login successful!";
        }else {
            return "Invalid credentials!";
        }
    }
}
