package com.example.spring_boot_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
@MapperScan("com.example.spring_boot_web.dao")
public class SpringBootWebRestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebRestfulcrudApplication.class, args);
    }



    @Bean
    public ViewResolver myResolver() {
        return new MyResolver();
    }


    private static class MyResolver implements ViewResolver {

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
