package com.example.spring_boot_web.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Create by czq
 * time on 2020/6/19  20:37
 */
@Data
@Component
public class User {
    private String username;

    private String password;

    private Integer userAge;


}
