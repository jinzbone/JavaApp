package com.springboot.catalog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user/")
public class UserController {

    @PostMapping("login")
    public String login(String username, String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在");
            return "用户名不存在";
        } catch (AuthenticationException e) {
            System.out.println("认证失败");
            return "认证失败";
        }
        return "登录成功";
    }

    @GetMapping("getUser")
    public Object getUser() {
        return SecurityUtils.getSubject();
    }

    @GetMapping("notics")
    public String notics() {
        return "通知";
    }
}
