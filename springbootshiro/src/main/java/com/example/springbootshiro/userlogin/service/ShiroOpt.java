package com.example.springbootshiro.userlogin.service;

import com.example.springbootshiro.model.User;

import java.util.Set;

public interface ShiroOpt {
    public User getUser(String username);
    public Set<String> getRolesById(Long userId);
    public Set<String> getPersById(Long userId);
}
