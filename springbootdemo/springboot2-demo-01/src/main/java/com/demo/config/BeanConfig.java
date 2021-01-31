package com.demo.config;

import com.demo.bean.Car;
import com.demo.bean.Pet;
import com.demo.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {Car.class})
public class BeanConfig {
    @Bean
    public User user(){
        return new User("张三",20);
    }

    @Bean
    public Pet pet(){
        return new Pet("五月");
    }
}
