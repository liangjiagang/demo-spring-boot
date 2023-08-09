package com.alagang.demo.springboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoAMapper {

    @Insert("insert into demo_spring_a(id,code) values (1,'123')")
    void addA();

    @Insert("insert into demo_spring_a(id,code) values (2,'1234')")
    void addB();




}
