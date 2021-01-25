package com.example.demo.service.impl;

import com.example.demo.service.CheckUserService;
import org.springframework.stereotype.Service;

@Service
public class CheckUserServiceImpl implements CheckUserService {

    @Override
    public boolean check() throws Exception {
        double random = Math.random()*10;
        if(random<5){
            throw new RuntimeException("check failed");
        }
        System.out.println("check check");
        return true;
    }
}
