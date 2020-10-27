package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/users")
@Api(tags = "用户模块")
public class UserController {
    @GetMapping("/getUser")
    public User getUser(@RequestParam String name){
//        String name = request.getParameter("name");
        System.out.println(name);
        User user = new User();
        user.setName(name);
        return user;
    }
    @GetMapping("/sayHi")
    public String sayHi(@RequestParam String sayHi){
        return sayHi;
    }
}
