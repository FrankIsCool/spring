package com.frank.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2019/11/18
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApplication {
        public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
