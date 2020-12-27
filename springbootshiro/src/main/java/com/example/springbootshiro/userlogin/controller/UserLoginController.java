package com.example.springbootshiro.userlogin.controller;

import com.example.springbootshiro.model.User;
import com.example.springbootshiro.userlogin.service.ShiroOpt;
import com.example.springbootshiro.userlogin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserLoginController {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public String getUser(@RequestParam String username, @RequestParam String password){
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();

        //用户是否已经登录，未登录则进行登录
        if (!currentUser.isAuthenticated()) {
            //封装用户输入的用户名和密码
            UsernamePasswordToken loginToken = new UsernamePasswordToken(username, password);
            try {
                //登录，进行密码比对，登录失败时将会抛出对应异常
                currentUser.login(loginToken);
            } catch (Exception e) {
                System.out.println("登陆错误");
            }
        }

        return "login user";
    }
    @GetMapping("please")
    public String please(){
        return "please login as admin!";
    }
    @GetMapping("admin")
    @RequiresRoles("role:admin")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
