package com.example.springbootshiro.mapper;

import com.example.springbootshiro.model.Permissions;
import com.example.springbootshiro.model.PermissionsExample;
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

public interface PermissionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @SelectProvider(type=PermissionsSqlProvider.class, method="countByExample")
    int countByExample(PermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @DeleteProvider(type=PermissionsSqlProvider.class, method="deleteByExample")
    int deleteByExample(PermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @Delete({
        "delete from sys_resources",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @Insert({
        "insert into sys_resources (id, name, ",
        "type, url, permission, ",
        "parent_id, sort, external, ",
        "available, icon, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{permission,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=BIGINT}, #{sort,jdbcType=INTEGER}, #{external,jdbcType=TINYINT}, ",
        "#{available,jdbcType=TINYINT}, #{icon,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Permissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @InsertProvider(type=PermissionsSqlProvider.class, method="insertSelective")
    int insertSelective(Permissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @SelectProvider(type=PermissionsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="external", property="external", jdbcType=JdbcType.TINYINT),
        @Result(column="available", property="available", jdbcType=JdbcType.TINYINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Permissions> selectByExample(PermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @Select({
        "select",
        "id, name, type, url, permission, parent_id, sort, external, available, icon, ",
        "create_time, update_time",
        "from sys_resources",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="external", property="external", jdbcType=JdbcType.TINYINT),
        @Result(column="available", property="available", jdbcType=JdbcType.TINYINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Permissions selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @UpdateProvider(type=PermissionsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Permissions record, @Param("example") PermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @UpdateProvider(type=PermissionsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Permissions record, @Param("example") PermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @UpdateProvider(type=PermissionsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Permissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    @Update({
        "update sys_resources",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "sort = #{sort,jdbcType=INTEGER},",
          "external = #{external,jdbcType=TINYINT},",
          "available = #{available,jdbcType=TINYINT},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Permissions record);
}