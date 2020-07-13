package com.example.spring_boot_web.entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by czq
 * time on 2020/7/9  19:48
 */
@Data
@ConfigurationProperties(prefix = "bean1")
public class Bean1 {
    private String name;
}
