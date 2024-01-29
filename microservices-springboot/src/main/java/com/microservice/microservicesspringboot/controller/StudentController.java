package com.microservice.microservicesspringboot.controller;

import com.microservice.microservicesspringboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Ramesh","Fadatare");
        return student;
    };

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ramesh","Fadatare"));
        students.add(new Student(2,"Umesh","Fadatare"));
        students.add(new Student(3,"Ram","Jadhav"));
        students.add(new Student(4,"Sanjay","Pawar"));

        return students;
    }

    //Springboot REST API with path variable
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student getPathVariable(@PathVariable("id") int id,
                                   @PathVariable("first-name") String firstName,
                                   @PathVariable("last-name") String lastName){
        return new Student(id,firstName,lastName);
    }
}
