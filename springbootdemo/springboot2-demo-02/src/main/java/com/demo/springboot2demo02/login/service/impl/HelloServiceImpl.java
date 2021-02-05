package com.demo.springboot2demo02.login.service.impl;

import com.demo.springboot2demo02.login.service.HelloService;
import com.demo.springboot2demo02.mapper.OrdersMapper;
import com.demo.springboot2demo02.model.Orders;
import com.demo.springboot2demo02.model.OrdersExample;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<Orders> getAll() {
        OrdersExample ordersExample = new OrdersExample();
        List<Orders> list = ordersMapper.selectByExample(ordersExample);
        return list;
    }
}
