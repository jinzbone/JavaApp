package com.example.demo.server.controller;

import com.example.demo.basemapper.SysRoleMapper;
import com.example.demo.basemodel.SysRoleExample;
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
    SysRoleMapper sysRoleMapper;


    @ApiOperation(value = "say 哈啰", notes = "say 哈啰 》》 ")
    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }


}
