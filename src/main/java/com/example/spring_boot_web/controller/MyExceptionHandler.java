package com.example.spring_boot_web.controller;

import com.example.spring_boot_web.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by czq
 * time on 2020/6/19  16:06
 */
@ControllerAdvice
public class MyExceptionHandler {


    //1.浏览器客户段返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> exceptionHandler(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "userNotExist");
//        map.put("message", e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistException.class)
    public String exceptionHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", "500");
        map.put("code", "userNotExist");
        map.put("message", e.getMessage());
        request.setAttribute("eh", map);
        return "forward:/error";
    }


}
