package com.example.springbootshiro.userlogin.service.impl;

import com.example.springbootshiro.mapper.*;
import com.example.springbootshiro.model.*;
import com.example.springbootshiro.userlogin.service.ShiroOpt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
@Service
public class ShiroOptImpl implements ShiroOpt {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    PermissionsMapper permissionsMapper;
    @Autowired
    RolePermissionsMapper rolePermissionsMapper;

    @Override
    public User getUser(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size()==1){
            log.info("getUser:"+userList.get(0));
            return userList.get(0);
        }
        return null;
    }

    @Override
    public Set<String> getRolesById(Long userId) {
        Set<String> resRoles = new HashSet<>();
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        List<UserRole> roleList= userRoleMapper.selectByExample(userRoleExample);
        for (int i = 0; i < roleList.size(); i++) {
            UserRole role = roleList.get(i);
            Role roleModel = roleMapper.selectByPrimaryKey(role.getRoleId());
            String roleName = roleModel.getName();
            resRoles.add(roleName);
        }
        System.out.println("角色："+resRoles);
        return resRoles;
    }

    @Override
    public Set<String> getPersById(Long userId) {
        Set<String> resPers = new HashSet<>();
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        List<UserRole> roleList= userRoleMapper.selectByExample(userRoleExample);
        for (int i = 0; i < roleList.size(); i++) {
            UserRole userRole = roleList.get(i);
            Long roleId = userRole.getRoleId();
            RolePermissionsExample example = new RolePermissionsExample();
            example.createCriteria().andRoleIdEqualTo(roleId);
            List<RolePermissions> rolePermissionsList = rolePermissionsMapper.selectByExample(example);
            for (int j = 0; j < rolePermissionsList.size(); j++) {
                RolePermissions rolePermissions = rolePermissionsList.get(j);
                Long resourceId = rolePermissions.getResourcesId();
                Permissions permissions = permissionsMapper.selectByPrimaryKey(resourceId);
                String perName = permissions.getName();
                resPers.add(perName);
            }
        }
        System.out.println("权限："+resPers);
        return resPers;
    }
}
