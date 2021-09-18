package com.example.demo.server.service;

public interface UserRepository{

    Object createCollection();
    Object createCollectionFixedSize();
    Object createCollectionValidation();
    Object getCollectionNames();
    boolean collectionExists();

    // 文档插入
    Object insert();
    Object insertMany();

    // 文档查询
    Object findAll();
    Object findById();
}
