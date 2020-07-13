package com.example.spring_boot_web.config;

import com.example.spring_boot_web.component.MyLocaleResolver;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.net.InetAddress;

/**
 * Create by czq
 * time on 2020/6/5  20:29
 */
//全面接管springmvc配置，web相关自动配置全部失效
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {




    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/first").setViewName("login");
        registry.addViewController("/main").setViewName("dashboard");
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//                SpringBoot已经做好了静态资源映射
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/*.ico","/", "/index.html", "/first", "/user/login", "/asserts/**", "/templates/**", "/webjars/**");
    }


    //所有的WebMvcConfigurer组件都会一起起作用
//    @Bean //将组件注册在容器
//    public WebMvcConfigurer webMvcConfigurerAdapter(){
//        WebMvcConfigurer adapter = new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/index").setViewName("login");
//                registry.addViewController("/main").setViewName("dashboard");
//            }
//        };
//        return adapter;
//    }


    //方法名一定要叫做LocaleResolver
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
