package com.alagang.demo.springboot.controller;


import com.alagang.demo.springboot.util.BeanUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 测试动态调用
 *
 * @author liangjiagang
 * @date 2023/08/08
 */
@RestController
public class DemoAController {


    @Resource
    private BeanUtil beanUtil;

    @GetMapping("/demo/a")
    @Transactional(rollbackFor = Exception.class)
    public String demoA(){
        beanUtil.getBeanMethodData("demoAServiceImpl","addServiceA");

        beanUtil.getBeanMethodData("demoAServiceImpl","addServiceB");

        //int a = 1/0;

        return "yes";
    }

}
