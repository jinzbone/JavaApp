package com.springboot.appconfig;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:db.properties"})
@MapperScan(value = {"com.springboot.appmapper"})
public class DaoConfig {

    @Bean(value = "dataSource")
    @ConfigurationProperties(prefix = "bzbh.datasource")
    @Primary
    public HikariDataSource hikariDataSource(){
        return new HikariDataSource();
    }
}
