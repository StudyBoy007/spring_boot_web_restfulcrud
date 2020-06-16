package com.example.spring_boot_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * Create by czq
 * time on 2020/6/3  17:01
 */
@Controller
@RequestMapping("/test")
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello controller!";
    }

    @RequestMapping("/test")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "test";
    }

    @RequestMapping("/first")
    public String first() {
        return "login";
    }
}
