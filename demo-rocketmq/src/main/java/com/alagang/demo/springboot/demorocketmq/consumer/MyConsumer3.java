package com.alagang.demo.springboot.demorocketmq.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @date 2022/4/20 19:53
 * @description 测试手动应答消息，抛出异常就相当于是消息消费失败
 */
@RocketMQMessageListener(topic = "topic-test3", consumerGroup = "consumer-group-test3")
@Component
@Slf4j
public class MyConsumer3 implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        String tags = message.getTags();

        if ("tag0".equals(tags)) {
            // 发生异常，顶层会返回ConsumeConcurrentlyStatus.RECONSUME_LATER。 相当于会重新发送。
            throw new RuntimeException("tag0 reconsume");
        } else {
            log.info("tags: {}, message: {}", tags, new String(message.getBody()));
        }
    }

}
