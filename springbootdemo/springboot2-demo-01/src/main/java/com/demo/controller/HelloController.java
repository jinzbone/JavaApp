package com.demo.controller;
import com.demo.bean.Car;
import com.demo.bean.Pet;
import com.demo.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloController {
    @Autowired
    User user;
    @Autowired
    Pet pet;
    @Autowired
    Car car;
    @ResponseBody
    @GetMapping("/car")
    public Car car(){
        log.info("进入car路径");
        return car;
    }
    @ResponseBody
    @GetMapping("/hello")
    public String sayHello(){
        System.out.println(user.getName()+ " "+user.getAge());
        System.out.println(pet.getName());
        return "Hello";
    }

}
