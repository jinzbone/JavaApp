package com.zj.service;

import com.zj.dao.UserDao;
import com.zj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User getUser(String userName){
        return userDao.getUser(userName);
    }
}
