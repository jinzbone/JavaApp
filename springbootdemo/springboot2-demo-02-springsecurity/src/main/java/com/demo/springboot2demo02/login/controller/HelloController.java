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
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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



    @GetMapping("/export")
    public ResponseEntity<FileSystemResource> export() throws UnsupportedEncodingException {
        return FileUtil.export();
    }

}
