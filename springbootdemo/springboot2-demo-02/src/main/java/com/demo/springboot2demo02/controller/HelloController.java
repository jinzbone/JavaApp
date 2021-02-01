package com.demo.springboot2demo02.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hi!";
    }

    @ResponseBody
    @GetMapping("/user")
    public String getUser(){
        return "GET user";
    }

    @ResponseBody
    @PostMapping("/user")
    public String postUser(){
        return "POST user";
    }

    @ResponseBody
    @PutMapping("/user")
    public String putUser(){
        return "PUT user";
    }

    @ResponseBody
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE user";
    }
}
