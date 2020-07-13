package com.example.spring_boot_web.entities;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by czq
 * time on 2020/7/9  19:57
 */
@Data
@EnableConfigurationProperties({Bean1.class})
public class Bean2 {
}
