package com.springboot.appcommon.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 为了方便观看，我将UserRealm类的实现写在这里了
 */
public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        // @Description: 执行认证逻辑
        String username = token.getUsername();
        if (username!=null){
            //JSONObject
        }

        if (token.getUsername() == null || !token.getUsername().equals("admin-name")){
            return null;
        }

        return new SimpleAuthenticationInfo("", "admin-pwd", "");
    }

    // 10. 前面被roles拦截后，需要授权才能登录，SecurityManager需要调用这里进行权限查询
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        // 10.1. 为了方便演示，这里直接写死返回了admin角色，所有能登录的角色都是admin了
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        return info;
    }
}