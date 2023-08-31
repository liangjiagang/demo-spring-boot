package com.alagang.demo.springboot.demorocketmq.consumer;

import com.alagang.demo.springboot.demorocketmq.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(
        topic = "topic-test2",
        consumerGroup = "my-group")
public class MyConsumerTest2 implements RocketMQReplyListener<User, User> {

    @Override
    public User onMessage(User message) {
        log.info("message test2: {}", message);
        User replyUser = new User();
        replyUser.setUserName("2222");
        replyUser.setUserAge(22);
        return replyUser;
    }
}
