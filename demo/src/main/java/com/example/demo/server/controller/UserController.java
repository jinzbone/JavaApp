package com.example.demo.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @ResponseBody
    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }
}
