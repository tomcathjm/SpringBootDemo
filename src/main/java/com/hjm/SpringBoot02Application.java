package com.hjm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBoot02Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringBoot02Application.class, args);
    }

}

