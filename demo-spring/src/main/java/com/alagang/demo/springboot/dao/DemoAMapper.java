package com.alagang.demo.springboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoAMapper {

    @Insert("insert into demo_spring_a(code) values ('123')")
    void addA();

    @Insert("insert into demo_spring_a(code) values (#{code})")
    void addB(@Param("code") String code);




}
