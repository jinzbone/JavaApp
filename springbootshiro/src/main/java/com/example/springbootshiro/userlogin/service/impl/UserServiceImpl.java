package com.example.springbootshiro.userlogin.service.impl;

import com.example.springbootshiro.mapper.UserMapper;
import com.example.springbootshiro.model.User;
import com.example.springbootshiro.model.UserExample;
import com.example.springbootshiro.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        UserExample example = new UserExample();
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    public String[] getPerms(String token) {
        String[] perms = new String[]{"wacatalog","test"};
        System.out.println(perms);
        return perms;
    }
}
