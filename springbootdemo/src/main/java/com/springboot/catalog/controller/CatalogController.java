package com.springboot.catalog.controller;

import com.springboot.appmapper.CustomersMapper;
import com.springboot.appmodel.Customers;
import com.springboot.catalog.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController

/* *
 * @Description:
 * @Author: zhangjing
 * @Date:
 * @Version 1.0
 */
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @Autowired
    CustomersMapper customersMapper;

    @GetMapping(value = "/test")
    public void getTest() throws SQLException {
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
