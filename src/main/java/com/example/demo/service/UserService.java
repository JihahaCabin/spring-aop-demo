package com.example.demo.service;

import com.example.demo.Entity.Student;

import java.util.List;

public interface UserService {

    List<Student> getStudents() throws Exception;
}
