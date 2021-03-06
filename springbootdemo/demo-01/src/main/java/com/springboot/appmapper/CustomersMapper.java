package com.springboot.appmapper;

import com.springboot.appmodel.Customers;
import com.springboot.appmodel.CustomersExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CustomersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @SelectProvider(type=CustomersSqlProvider.class, method="countByExample")
    int countByExample(CustomersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @DeleteProvider(type=CustomersSqlProvider.class, method="deleteByExample")
    int deleteByExample(CustomersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @Delete({
        "delete from customers",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer custId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @Insert({
        "insert into customers (cust_id, cust_name, ",
        "cust_address, cust_city, ",
        "cust_state, cust_zip, cust_country, ",
        "cust_contact, cust_email)",
        "values (#{custId,jdbcType=INTEGER}, #{custName,jdbcType=CHAR}, ",
        "#{custAddress,jdbcType=CHAR}, #{custCity,jdbcType=CHAR}, ",
        "#{custState,jdbcType=CHAR}, #{custZip,jdbcType=CHAR}, #{custCountry,jdbcType=CHAR}, ",
        "#{custContact,jdbcType=CHAR}, #{custEmail,jdbcType=CHAR})"
    })
    int insert(Customers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @InsertProvider(type=CustomersSqlProvider.class, method="insertSelective")
    int insertSelective(Customers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @SelectProvider(type=CustomersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_name", property="custName", jdbcType=JdbcType.CHAR),
        @Result(column="cust_address", property="custAddress", jdbcType=JdbcType.CHAR),
        @Result(column="cust_city", property="custCity", jdbcType=JdbcType.CHAR),
        @Result(column="cust_state", property="custState", jdbcType=JdbcType.CHAR),
        @Result(column="cust_zip", property="custZip", jdbcType=JdbcType.CHAR),
        @Result(column="cust_country", property="custCountry", jdbcType=JdbcType.CHAR),
        @Result(column="cust_contact", property="custContact", jdbcType=JdbcType.CHAR),
        @Result(column="cust_email", property="custEmail", jdbcType=JdbcType.CHAR)
    })
    List<Customers> selectByExample(CustomersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @Select({
        "select",
        "cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, ",
        "cust_contact, cust_email",
        "from customers",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_name", property="custName", jdbcType=JdbcType.CHAR),
        @Result(column="cust_address", property="custAddress", jdbcType=JdbcType.CHAR),
        @Result(column="cust_city", property="custCity", jdbcType=JdbcType.CHAR),
        @Result(column="cust_state", property="custState", jdbcType=JdbcType.CHAR),
        @Result(column="cust_zip", property="custZip", jdbcType=JdbcType.CHAR),
        @Result(column="cust_country", property="custCountry", jdbcType=JdbcType.CHAR),
        @Result(column="cust_contact", property="custContact", jdbcType=JdbcType.CHAR),
        @Result(column="cust_email", property="custEmail", jdbcType=JdbcType.CHAR)
    })
    Customers selectByPrimaryKey(Integer custId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @UpdateProvider(type=CustomersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Customers record, @Param("example") CustomersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @UpdateProvider(type=CustomersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Customers record, @Param("example") CustomersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @UpdateProvider(type=CustomersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Customers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
     *
     * @mbggenerated Tue Dec 22 23:50:08 CST 2020
     */
    @Update({
        "update customers",
        "set cust_name = #{custName,jdbcType=CHAR},",
          "cust_address = #{custAddress,jdbcType=CHAR},",
          "cust_city = #{custCity,jdbcType=CHAR},",
          "cust_state = #{custState,jdbcType=CHAR},",
          "cust_zip = #{custZip,jdbcType=CHAR},",
          "cust_country = #{custCountry,jdbcType=CHAR},",
          "cust_contact = #{custContact,jdbcType=CHAR},",
          "cust_email = #{custEmail,jdbcType=CHAR}",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customers record);
}