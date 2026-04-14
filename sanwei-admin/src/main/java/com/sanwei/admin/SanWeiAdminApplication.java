package com.sanwei.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SanWeiAppplication
 * 主服务启动类
 * @author caiyang
 * @date 2026/4/5
 */
@SpringBootApplication(scanBasePackages = {"com.sanwei.admin", "com.sanwei.system"})
public class SanWeiAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanWeiAdminApplication.class, args);
        System.out.println("=====================项目启动完成==================");
    }
}
