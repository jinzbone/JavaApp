package com.example.demo.server.controller;

import com.example.demo.basemapper.CustomersMapper;
import com.example.demo.basemodel.Customers;
import com.example.demo.basemodel.CustomersExample;
import com.example.demo.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserService userService;


    @ResponseBody
    @GetMapping("/hello")
    public String getHello(){
        logger.info("第一次查询："+userService.findByName());
        logger.info("第二次查询："+userService.findByName());
        return "hello";
    }

}
