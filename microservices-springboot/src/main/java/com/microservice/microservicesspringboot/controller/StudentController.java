package com.microservice.microservicesspringboot.controller;

import com.microservice.microservicesspringboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Ramesh","Fadatare");
        return student;
    };
}
