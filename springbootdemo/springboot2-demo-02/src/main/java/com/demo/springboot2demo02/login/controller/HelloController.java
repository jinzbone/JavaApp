package com.demo.springboot2demo02.login.controller;

import com.demo.springboot2demo02.utils.FileUtil;
import com.demo.springboot2demo02.utils.common.CommonReturnType;
import com.demo.springboot2demo02.domain.User;
import com.demo.springboot2demo02.login.service.HelloService;
import com.demo.springboot2demo02.mapper.SysResourcesMapper;
import com.demo.springboot2demo02.model.Orders;
import com.demo.springboot2demo02.model.SysResources;
import com.demo.springboot2demo02.model.SysResourcesExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @Autowired
    SysResourcesMapper sysResourcesMapper;

    @GetMapping("/getpers")
    public CommonReturnType getpers(@RequestParam("pagesize") int pageSize,
                                    @RequestParam("pagenum") int pageNum){
        Page<SysResources> page = PageHelper.startPage(pageNum, pageSize);
        SysResourcesExample example = new SysResourcesExample();
        List<SysResources> list = sysResourcesMapper.selectByExample(example);
        System.out.println("总共条数："+page.getTotal());
        PageInfo<SysResources> pageInfo = new PageInfo<>(list);
        // 返回 共几页、共多少条数据
        JSONObject object = new JSONObject();
        object.accumulate("total", pageInfo.getTotal());
        object.accumulate("pages", pageInfo.getNavigateLastPage());
        object.accumulate("data", pageInfo.getList());
        return CommonReturnType.ok(object);
    }


    @GetMapping("/data")
    public List data(){
        int pageNum = 1;//第几页
        int pageSize = 3;//每页数据条数
        Page<Orders> page = PageHelper.startPage(pageNum, pageSize);
        helloService.getAll();//从数据库中查出所有数据
        System.out.println("总共条数："+page.getTotal());
        for (Orders orders : page.getResult()) {
            System.out.println(orders.getCustId());
        }
        return page.getResult();
    }

    @GetMapping("/user")
    public User getUser(){
        log.info("进入 getUser");
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("aaa");
        log.info("离开 getUser");
        return user;
    }


    @GetMapping("/export")
    public ResponseEntity<FileSystemResource> export() throws UnsupportedEncodingException {
        return FileUtil.export();
    }

}
