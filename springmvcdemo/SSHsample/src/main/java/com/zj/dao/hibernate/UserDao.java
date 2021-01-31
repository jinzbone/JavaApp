package com.zj.dao.hibernate;

import com.zj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addUser(User user){
        hibernateTemplate.save(user);
    }
}
