package com.demo.springboot2demo02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("select count(*) from orders")
    public int selectAll();
}
