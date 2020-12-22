package com.springboot.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class CatalogDao {
    public void getDao(){
        log.info("getDAO");
    }
}
