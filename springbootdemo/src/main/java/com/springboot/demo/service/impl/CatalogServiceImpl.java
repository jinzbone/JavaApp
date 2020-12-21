package com.springboot.demo.service.impl;

import com.springboot.demo.dao.CatalogDao;
import com.springboot.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogDao catalogDao;
    @Override
    public void getService() {
        System.out.println("getService");
        catalogDao.getDao();
    }
}
