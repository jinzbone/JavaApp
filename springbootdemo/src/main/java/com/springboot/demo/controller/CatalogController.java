package com.springboot.demo.controller;

import com.springboot.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @GetMapping(value = "/test")
    public void getTest(){
        System.out.println("getController");
        catalogService.getService();
    }
}
