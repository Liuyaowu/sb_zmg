package com.mobei.bootlaunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"}) //读取xml配置文件
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
