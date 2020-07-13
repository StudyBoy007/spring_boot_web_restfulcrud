package com.example.spring_boot_web.Filter;


import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.*;
import java.io.IOException;

/**
 * Create by czq
 * time on 2020/6/19  19:48
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
