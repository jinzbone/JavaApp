package com.zj.service;

import com.zj.dao.hibernate.UserDao;
import com.zj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void addUser(User user){
        userDao.addUser(user);
    }
}
