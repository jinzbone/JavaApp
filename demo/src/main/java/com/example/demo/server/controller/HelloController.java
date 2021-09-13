package com.example.demo.server.controller;
import com.example.demo.basemapper.CustomersMapper;
import com.example.demo.basemodel.Customers;
import com.example.demo.basemodel.User;
import com.example.demo.config.Config;
import com.example.demo.config.DataSourcePropConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "哈啰Controller")
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    DataSourcePropConfig dataSourcePropConfig;

    @Autowired
    Config config;

    @Autowired
    CustomersMapper customersMapper;

    @ApiOperation(value = "say 哈啰", notes = "say 哈啰 》》 ")
    @GetMapping("/hello")
    public void index() {
        Customers customers = new Customers();
        customers.setCustName("张静");
        customersMapper.insert(customers);
    }


}
