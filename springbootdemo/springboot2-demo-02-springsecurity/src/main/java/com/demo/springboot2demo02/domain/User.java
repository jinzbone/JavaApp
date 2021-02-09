package com.demo.springboot2demo02.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private String username;
    private String password;
}
