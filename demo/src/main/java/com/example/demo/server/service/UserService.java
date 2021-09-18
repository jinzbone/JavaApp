package com.example.demo.server.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "users")
public interface UserService {

    @Cacheable
    String findByName();
}
