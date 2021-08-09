package com.example.demo.basemodel;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class User{

    public User(@Value("${typename}") String typename){
        System.out.println("typename111: "+typename);
    }


}
