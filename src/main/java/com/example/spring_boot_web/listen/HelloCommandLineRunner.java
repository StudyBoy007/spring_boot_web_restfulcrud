package com.example.spring_boot_web.listen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Create by czq
 * time on 2020/7/9  15:24
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("HelloCommandLineRunner....run....");
    }
}
