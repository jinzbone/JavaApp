package com.springboot.catalog.controller;

import com.springboot.appmapper.CustomersMapper;
import com.springboot.appmodel.Customers;
import com.springboot.catalog.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @Autowired
    CustomersMapper customersMapper;

    // @Description:
    @GetMapping(value = "/test")
    public void getTest(){
        log.info("getController");
        catalogService.getService();
    }

    // Restful
    @GetMapping(value = "/cust/{id}")
    public Customers getCustomers(@PathVariable("id") Integer id){
        Customers customers = customersMapper.selectByPrimaryKey(id);
        return customers;
    }
}
