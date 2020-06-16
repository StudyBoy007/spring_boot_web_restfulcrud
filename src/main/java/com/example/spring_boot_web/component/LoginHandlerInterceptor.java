package com.example.spring_boot_web.component;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by czq
 * time on 2020/6/14  20:02
 * 登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /*
    方法执行前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("REQUEST："+request.getRequestURI());
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", "没有权限请先登录");
            request.getRequestDispatcher("/first").forward(request, response);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
