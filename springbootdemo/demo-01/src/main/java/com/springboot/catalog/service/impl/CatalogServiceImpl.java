package com.springboot.catalog.service.impl;

import com.springboot.catalog.dao.CatalogDao;
import com.springboot.catalog.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogDao catalogDao;
    @Override
    public void getService() {
        log.info("getService");
        catalogDao.getDao();
    }
}
