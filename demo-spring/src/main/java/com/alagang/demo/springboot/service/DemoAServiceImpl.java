package com.alagang.demo.springboot.service;

import com.alagang.demo.springboot.dao.DemoAMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoAServiceImpl {

    @Resource
    private DemoAMapper demoAMapper;

    public String addServiceA(){
        demoAMapper.addA();
        return "AAAAAAA";
    }

    public String addServiceB(){
        demoAMapper.addB();
        return "BBBBBBB";
    }
}
