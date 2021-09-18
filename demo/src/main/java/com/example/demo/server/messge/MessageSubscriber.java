package com.example.demo.server.messge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;


@Service
public class MessageSubscriber {

    private static String CHANNEL = "jinzbone";

    Logger logger = LoggerFactory.getLogger(MessageSubscriber.class);

    public MessageSubscriber(RedisTemplate redisTemplate) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        redisConnection.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                // 收到消息的处理逻辑
                logger.info("Receive message : " + message);
            }
        }, CHANNEL.getBytes(StandardCharsets.UTF_8));

    }
}
