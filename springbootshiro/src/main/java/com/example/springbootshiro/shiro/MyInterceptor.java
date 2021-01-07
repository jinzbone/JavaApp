package com.example.springbootshiro.shiro;

import com.example.springbootshiro.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        // 获取出方法上的Access注解
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }
        // 从参数中取出用户身份并验证
        String perm = access.perm();
        String token = request.getHeader("token");
        System.out.println("token: "+token);
//        String[] authPerms = userService.getPerms(token);
        String[] authPerms = new String[]{"wacatalog","test"};
        boolean b = false;
        System.out.println("authPerms: "+authPerms);
        for (int i = 0; i < authPerms.length; i++) {
            String authPerm = authPerms[i];
            if (authPerm.equals(perm)){
                b = true;
                break;
            }
        }
        if (b) return true;
        else {
            System.out.println("permission denied");
            response.setStatus(403);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
