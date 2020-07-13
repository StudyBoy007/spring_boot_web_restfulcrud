package com.example.spring_boot_web.listen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

/**
 * Create by czq
 * time on 2020/7/9  15:02
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {

    }



    @Override 
    public void starting() {
        System.out.println("HelloSpringApplicationRunListener....starting....");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemEnvironment();
        System.out.println("HelloSpringApplicationRunListener....environmentPrepared...."+o);

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener....contextPrepared....");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener....contextLoaded....");

    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener....started....");

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener....running....");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
