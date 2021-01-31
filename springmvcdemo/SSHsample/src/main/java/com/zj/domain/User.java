package com.zj.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "USER_NAME")
    private String user_name;

    @Column(name = "PASSWORD")
    private String password;
}
