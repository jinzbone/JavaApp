package com.demo.springboot2demo02.config;

import com.demo.springboot2demo02.login.service.impl.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailService myUserDetailService;

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 用户登陆时的用户名和密码校验
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 根据用户名，从数据库里查到该用户的密码（并用bcrypt加密），然后返回该User对象
        auth.userDetailsService(myUserDetailService).passwordEncoder(bcryptPasswordEncoder());
    }

    // 配置哪些页面需要登陆才能访问、哪些不用
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
            logout().logoutUrl("/logout").logoutSuccessUrl("/hi").permitAll()
            .and().formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/loginprocess")
                .defaultSuccessUrl("/success.html")
                .permitAll()
            .and().authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
            .and().csrf().disable();
    }
}
