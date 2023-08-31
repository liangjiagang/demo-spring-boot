package com.alagang.demo.springboot.demorocketmq.controller;

import com.alagang.demo.springboot.demorocketmq.pojo.User;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("test")
    public String test(){
        sendString();
        return "ok";
    }

    private void sendString() {
        String springTopic = "demo-b";
        /***********第一种发送方式*********/
        // 同步发送消息。默认重复两次。不指定超时时间会拿producer 全局的默认超时时间(默认3s)
        SendResult sendResult = rocketMQTemplate.syncSend(springTopic, "Hello, World!");
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", springTopic, sendResult);
    }


    @GetMapping("test2")
    public String test2(){
        testSendAndReceive();
        return "ok2";
    }

    /**
     * 发送具有回传消息的消息。 要求消费者实现 RocketMQReplyListener 接收并回复消息
     *
     */
    private void testSendAndReceive() {

        String objectRequestTopic = "topic-test2";

        User user = new User();
        user.setUserAge(9);
        user.setUserName("test");

        // Send request in async mode and receive a reply of User type.
        rocketMQTemplate.sendAndReceive(objectRequestTopic, user, new RocketMQLocalRequestCallback<User>() {
            @Override
            public void onSuccess(User message) {
                System.out.printf("send user object and receive %s %n", message.toString());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
            }
        }, 5000);
    }






}
