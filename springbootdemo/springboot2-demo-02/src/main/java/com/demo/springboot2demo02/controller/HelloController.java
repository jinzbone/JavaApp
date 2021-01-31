package com.demo.springboot2demo02.controller;

import com.demo.springboot2demo02.mapper.OrderMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {
    @Autowired
    OrderMapper orderMapper;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        int a = orderMapper.selectAll();
        System.out.println("a: "+a);
        return "Hi!";
    }
}
