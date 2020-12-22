package com.springboot.demo.controller;

import com.springboot.demo.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RestController
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @Autowired
    DataSource dataSource;

    @GetMapping(value = "/test")
    public void getTest() throws SQLException {
        log.info("getController");
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        catalogService.getService();
    }
}
