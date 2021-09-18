package com.example.demo.server.messge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {

    private static String CHANNEL = "jinzbone";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public MessagePublisher(RedisTemplate<String, String> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/publish")
    public void publish(@RequestParam String message) {
        // 发送消息
        redisTemplate.convertAndSend(CHANNEL, message);
    }


}
