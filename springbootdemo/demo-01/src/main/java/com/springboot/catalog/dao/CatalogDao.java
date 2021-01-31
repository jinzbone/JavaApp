package com.springboot.catalog.dao;

import com.springboot.appmapper.CustomersMapper;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class CatalogDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void getDao(){
        log.info("getDAO");
    }
}
