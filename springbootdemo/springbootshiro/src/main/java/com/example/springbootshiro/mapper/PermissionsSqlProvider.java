package com.example.springbootshiro.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.example.springbootshiro.model.Permissions;
import com.example.springbootshiro.model.PermissionsExample.Criteria;
import com.example.springbootshiro.model.PermissionsExample.Criterion;
import com.example.springbootshiro.model.PermissionsExample;
import java.util.List;
import java.util.Map;

public class PermissionsSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String countByExample(PermissionsExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_resources");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String deleteByExample(PermissionsExample example) {
        BEGIN();
        DELETE_FROM("sys_resources");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String insertSelective(Permissions record) {
        BEGIN();
        INSERT_INTO("sys_resources");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPermission() != null) {
            VALUES("permission", "#{permission,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getSort() != null) {
            VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getExternal() != null) {
            VALUES("external", "#{external,jdbcType=TINYINT}");
        }
        
        if (record.getAvailable() != null) {
            VALUES("available", "#{available,jdbcType=TINYINT}");
        }
        
        if (record.getIcon() != null) {
            VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String selectByExample(PermissionsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("type");
        SELECT("url");
        SELECT("permission");
        SELECT("parent_id");
        SELECT("sort");
        SELECT("external");
        SELECT("available");
        SELECT("icon");
        SELECT("create_time");
        SELECT("update_time");
        FROM("sys_resources");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Permissions record = (Permissions) parameter.get("record");
        PermissionsExample example = (PermissionsExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_resources");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getPermission() != null) {
            SET("permission = #{record.permission,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getSort() != null) {
            SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getExternal() != null) {
            SET("external = #{record.external,jdbcType=TINYINT}");
        }
        
        if (record.getAvailable() != null) {
            SET("available = #{record.available,jdbcType=TINYINT}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_resources");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("type = #{record.type,jdbcType=VARCHAR}");
        SET("url = #{record.url,jdbcType=VARCHAR}");
        SET("permission = #{record.permission,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        SET("sort = #{record.sort,jdbcType=INTEGER}");
        SET("external = #{record.external,jdbcType=TINYINT}");
        SET("available = #{record.available,jdbcType=TINYINT}");
        SET("icon = #{record.icon,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        PermissionsExample example = (PermissionsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String updateByPrimaryKeySelective(Permissions record) {
        BEGIN();
        UPDATE("sys_resources");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPermission() != null) {
            SET("permission = #{permission,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getSort() != null) {
            SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getExternal() != null) {
            SET("external = #{external,jdbcType=TINYINT}");
        }
        
        if (record.getAvailable() != null) {
            SET("available = #{available,jdbcType=TINYINT}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    protected void applyWhere(PermissionsExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}