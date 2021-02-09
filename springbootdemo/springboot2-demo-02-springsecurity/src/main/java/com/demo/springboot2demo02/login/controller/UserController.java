package com.demo.springboot2demo02.login.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Secured({"ROLE_admin", "hello"})
@Controller
public class UserController {


    @GetMapping("add")
    @ResponseBody
    public String add(){
        return "add";
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/hi")
    @ResponseBody
    public String hi(){
        return "Hi.";
    }
    @GetMapping("/index")
    @ResponseBody
    public String index(){
        return "indexpage.";
    }

}
