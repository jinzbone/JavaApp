//package com.example.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
///**
// * @Title: 取消springsecurity默认的登录验证
// * @Author: ZhangJing
// * @Date:
// * @Description:
// * @Version 1.0
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//}
