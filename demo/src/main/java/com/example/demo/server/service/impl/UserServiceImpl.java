package com.example.demo.server.service.impl;

import com.example.demo.basemapper.CustomersMapper;
import com.example.demo.basemodel.Customers;
import com.example.demo.basemodel.CustomersExample;
import com.example.demo.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    CustomersMapper customersMapper;

    @Override
    public String findByName() {
        CustomersExample example = new CustomersExample();
        example.createCriteria().andCustNameEqualTo("张静");
        List<Customers> customersList = customersMapper.selectByExample(example);
        logger.info("查询到用户："+customersList.get(0).toString());
        return customersList.get(0).getCustName();
    }


}
