package com.zj.controller;

import com.zj.domain.User;
import com.zj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getuser", method = RequestMethod.POST)
    public ResponseEntity<String> getUser(){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        User user = new User();
        user.setUser_name("xiaoming");
        user.setPassword("123456");
        userService.addUser(user);
        String userJson = "{user_name:"+user.getUser_name()+",password:"+user.getPassword()+"}";
        return new ResponseEntity<String>(userJson, httpHeaders, HttpStatus.OK);
    }
}
