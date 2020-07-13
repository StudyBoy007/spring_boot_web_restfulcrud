package com.example.spring_boot_web.exception;

/**
 * Create by czq
 * time on 2020/6/19  15:43
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
