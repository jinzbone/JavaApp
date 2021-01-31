package com.example.springbootshiro.shiro;

import com.example.springbootshiro.model.User;
import com.example.springbootshiro.userlogin.service.ShiroOpt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    ShiroOpt shiroOpt;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Long userId = user.getId().longValue();
        Set<String> roles = shiroOpt.getRolesById(userId);
        Set<String> pers = shiroOpt.getPersById(userId);
        info.addRoles(roles);
        info.addStringPermissions(pers);
        System.out.println("授权角色："+roles);
        System.out.println("授权权限："+pers);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = shiroOpt.getUser(username);
        if (user==null)return null;
        return new SimpleAuthenticationInfo(user, token.getPassword(), getName());
    }
}
