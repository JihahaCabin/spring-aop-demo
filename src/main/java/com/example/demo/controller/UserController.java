package com.example.demo.controller;

import com.example.demo.Entity.Student;
import com.example.demo.anotation.AdminOnly;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    @AdminOnly
    public List<Student> getStudents()throws Exception{
        List<Student> students = userService.getStudents();
        return students;
    }


}
