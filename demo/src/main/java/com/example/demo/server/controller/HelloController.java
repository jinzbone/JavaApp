package com.example.demo.server.controller;

import com.example.demo.basemapper.SysRoleMapper;
import com.example.demo.basemodel.SysRoleExample;
import com.example.demo.basemodel.User;
import com.example.demo.config.Config;
import com.example.demo.config.DataSourcePropConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    DataSourcePropConfig dataSourcePropConfig;

    @Autowired
    Config config;

    @Autowired
    SysRoleMapper sysRoleMapper;


    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }


}
