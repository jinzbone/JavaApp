package com.demo.springboot2demo02.login.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVo {
    private String username;
    private int age;
    private String sex;
}
