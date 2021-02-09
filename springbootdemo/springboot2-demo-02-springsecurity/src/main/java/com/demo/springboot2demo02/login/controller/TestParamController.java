package com.demo.springboot2demo02.login.controller;


import com.demo.springboot2demo02.domain.User;
import com.demo.springboot2demo02.mapper.SysUserMapper;
import com.demo.springboot2demo02.model.SysUser;
import com.demo.springboot2demo02.model.SysUserExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
public class TestParamController {

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    SysUserMapper sysUserMapper;

    @GetMapping("/register")
    public String register(@RequestParam("username") String username,
                            @RequestParam("password") String password){
        log.info("进入register");
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if (list.size()<1){
            SysUser sysUser = new SysUser();
            String encodedPassword = bcryptPasswordEncoder.encode(password);
            sysUser.setUsername(username);
            sysUser.setPassword(encodedPassword);
            int n = sysUserMapper.insert(sysUser);
            if (n>0) return "注册成功！";
            else return "注册失败！";
        }else {
            return "用户名已存在，请修改用户并重试！";
        }
    }
//    @GetMapping("/login")
//    public String login(HttpSession session,
//                        @RequestParam("username") String username,
//                        @RequestParam("password") String password){
//        log.info("进入login");
//        SysUserExample example = new SysUserExample();
//        example.createCriteria().andUsernameEqualTo(username);
//        List<SysUser> list = sysUserMapper.selectByExample(example);
//        if (list.size()>0){
//            SysUser sysUser = list.get(0);
//            String encodedPassword = sysUser.getPassword();
//            if (bcryptPasswordEncoder.matches(password, encodedPassword)){
//                log.info("明文密码：" + password);
//                log.info("密文密码：" + encodedPassword);
//                log.info("离开login");
//                return "你已成功登陆！";
//            }
//            else {
//                return "登陆失败";
//            }
//        }else {
//            return "登陆失败";
//        }
//    }

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
