package com.alagang.demo.springboot.demorocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "demo-b", consumerGroup = "my-group")
public class MyConsumer2 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {

        System.out.println("Received message22222: retry");

        int a = 1/0;
        // 处理消息的逻辑
        System.out.println("Received message22222: " + message);
    }
}
