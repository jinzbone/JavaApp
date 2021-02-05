package com.demo.springboot2demo02.mapper.ext;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapperExt {
    @Select("select cust_id from orders where order_num=#{num}")
    public int getSum(int num);
}
