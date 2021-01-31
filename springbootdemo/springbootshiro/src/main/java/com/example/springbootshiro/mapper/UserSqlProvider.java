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

import com.example.springbootshiro.model.User;
import com.example.springbootshiro.model.UserExample.Criteria;
import com.example.springbootshiro.model.UserExample.Criterion;
import com.example.springbootshiro.model.UserExample;
import java.util.List;
import java.util.Map;

public class UserSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String countByExample(UserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_user");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String deleteByExample(UserExample example) {
        BEGIN();
        DELETE_FROM("sys_user");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("sys_user");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            VALUES("qq", "#{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getGender() != null) {
            VALUES("gender", "#{gender,jdbcType=TINYINT}");
        }
        
        if (record.getAvatar() != null) {
            VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            VALUES("user_type", "#{userType,jdbcType=CHAR}");
        }
        
        if (record.getRegIp() != null) {
            VALUES("reg_ip", "#{regIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginIp() != null) {
            VALUES("last_login_ip", "#{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTime() != null) {
            VALUES("last_login_time", "#{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoginCount() != null) {
            VALUES("login_count", "#{loginCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
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
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String selectByExample(UserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("username");
        SELECT("password");
        SELECT("nickname");
        SELECT("mobile");
        SELECT("email");
        SELECT("qq");
        SELECT("birthday");
        SELECT("gender");
        SELECT("avatar");
        SELECT("user_type");
        SELECT("reg_ip");
        SELECT("last_login_ip");
        SELECT("last_login_time");
        SELECT("login_count");
        SELECT("remark");
        SELECT("status");
        SELECT("create_time");
        SELECT("update_time");
        FROM("sys_user");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_user");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            SET("username = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{record.qq,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{record.birthday,jdbcType=DATE}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{record.gender,jdbcType=TINYINT}");
        }
        
        if (record.getAvatar() != null) {
            SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            SET("user_type = #{record.userType,jdbcType=CHAR}");
        }
        
        if (record.getRegIp() != null) {
            SET("reg_ip = #{record.regIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginIp() != null) {
            SET("last_login_ip = #{record.lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTime() != null) {
            SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoginCount() != null) {
            SET("login_count = #{record.loginCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
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
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_user");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("username = #{record.username,jdbcType=VARCHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("qq = #{record.qq,jdbcType=VARCHAR}");
        SET("birthday = #{record.birthday,jdbcType=DATE}");
        SET("gender = #{record.gender,jdbcType=TINYINT}");
        SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        SET("user_type = #{record.userType,jdbcType=CHAR}");
        SET("reg_ip = #{record.regIp,jdbcType=VARCHAR}");
        SET("last_login_ip = #{record.lastLoginIp,jdbcType=VARCHAR}");
        SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        SET("login_count = #{record.loginCount,jdbcType=INTEGER}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("sys_user");
        
        if (record.getUsername() != null) {
            SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{gender,jdbcType=TINYINT}");
        }
        
        if (record.getAvatar() != null) {
            SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            SET("user_type = #{userType,jdbcType=CHAR}");
        }
        
        if (record.getRegIp() != null) {
            SET("reg_ip = #{regIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginIp() != null) {
            SET("last_login_ip = #{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTime() != null) {
            SET("last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoginCount() != null) {
            SET("login_count = #{loginCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sun Dec 27 16:04:48 CST 2020
     */
    protected void applyWhere(UserExample example, boolean includeExamplePhrase) {
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