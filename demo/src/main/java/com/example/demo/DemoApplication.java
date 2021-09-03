package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title:
 * @Author: ZhangJing
 * @Date:
 * @Description:
 * @Version 1.0
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo.basemapper"})
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
