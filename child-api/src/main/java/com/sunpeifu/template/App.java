package com.sunpeifu.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @Date 2020/1/3 10:30 上午
 * @Author daike
 * @description
 */
@SpringBootConfiguration
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }
}
