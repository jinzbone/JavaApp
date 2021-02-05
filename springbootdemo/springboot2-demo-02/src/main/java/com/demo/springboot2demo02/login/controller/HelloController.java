package com.demo.springboot2demo02.login.controller;

import com.demo.springboot2demo02.domain.User;
import com.demo.springboot2demo02.login.service.HelloService;
import com.demo.springboot2demo02.model.Orders;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
        File file = getFile();
        if (file == null) {
            return null;
        }
        System.out.println(file.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        // 对中文进行转码
        headers.add("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("UTF-8"), "iso-8859-1"));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));
    }

    public File getFile() {
        //resources文件夹中保存要下载的文件名
        String fileName = "test.txt";
        //指定目标文件名，此处将文件保存在项目的resource目录下，也可以保存在本地的其他目录下
        String destFileName = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + fileName;
        //新建目标文件
        System.out.println(destFileName);
        File destFile = new File(destFileName);
        return destFile;
    }
}
