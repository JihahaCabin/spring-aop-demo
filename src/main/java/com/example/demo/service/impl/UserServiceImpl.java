package com.example.demo.service.impl;

import com.example.demo.Entity.Student;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<Student> getStudents()throws Exception{

        List<Student> resultList = new ArrayList<>();

        if(Math.random()*10>5)
        {
            throw new RuntimeException("方法抛出异常了");
        }
        for(int i=0;i<10;i++){
            Student student = new Student(i, "name-" + 1, null, null, 20 + i);
            resultList.add(student);
        }

        return resultList;

    }
}
