package com.example.spring_boot_web.config;

import com.example.spring_boot_web.Filter.MyFilter;
import com.example.spring_boot_web.entities.Dog;
import com.example.spring_boot_web.entities.User;
import com.example.spring_boot_web.listen.MyListen;
import com.example.spring_boot_web.servlet.MyServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * Create by czq
 * time on 2020/6/19  19:00
 */
@Configuration
public class MyServerConfig {
    //注册三大组件

    //注册servlet
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new
                MyServlet(), "/myServlet");
        return registrationBean;
    }


    //注册拦截器
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet", "/test/hello"));
        return filterFilterRegistrationBean;
    }


    //注册监听器
    @Bean
    public ServletListenerRegistrationBean myListen() {
        return new ServletListenerRegistrationBean<MyListen>(new MyListen());
    }


    
    //定制器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8090);
            }
        };
    }


    @Bean
    @ConditionalOnBean(value = User.class, name = "user")
    public Dog myDog(User user) {
        Dog dog = new Dog();
        dog.setName(user.getUsername());
        return dog;
    }


}
