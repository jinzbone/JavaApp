package com.demo.springboot2demo02.login.controller;


import com.demo.springboot2demo02.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class TestParamController {

    @GetMapping({"/", "/login"})
    public String login(User user, HttpSession session){
        log.info("进入login");
        if ("root".equals(user.getUsername()) && "123456".equals(user.getPassword())){
            session.setAttribute("user", user);
            return "redirect:/main";
        }
        log.info("离开login");
        return "/login";
    }

    @GetMapping("/main")
    public String mainPage(HttpSession session){
        log.info("进入main");
        Object object = session.getAttribute("user");
        if (object !=null){
            return "Welcome to main Page";
        }
        log.info("离开main");
        return "Please login first";
    }









}
