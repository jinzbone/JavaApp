package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping("/get")
    public User getUser(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println(name);
        User user = new User();
        user.setName(name);
        return user;
    }
}
