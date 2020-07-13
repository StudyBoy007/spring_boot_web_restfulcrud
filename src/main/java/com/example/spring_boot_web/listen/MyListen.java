package com.example.spring_boot_web.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Create by czq
 * time on 2020/6/19  20:30
 */
public class MyListen implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web服务开始启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web服务关闭");
    }
}
