package com.example.springbootshiro.userlogin.service;

import com.example.springbootshiro.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public String[] getPerms(String token);
}
