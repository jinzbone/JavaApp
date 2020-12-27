package com.example.springbootshiro.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
@MapperScan(value = {"com.example.springbootshiro.mapper"})
public class DaoConfig {

    @Bean
    @ConfigurationProperties(prefix = "bzbh.datasource")
    public HikariDataSource dataSource(){
        return new HikariDataSource();
    }
}
