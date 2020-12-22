package com.springboot.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:db.properties"})
public class DaoConfig {


    @Value("${bzbh.datasource.username}")
    private String username;
    @Value("${bzbh.datasource.password}")
    private String password;
    @Value("${bzbh.datasource.url}")
    private String url;
    @Value("${bzbh.datasource.driver-class-name}")
    private String driverClassName;


    @Bean(value = "dataSource")
    @Primary
    public HikariDataSource hikariDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
