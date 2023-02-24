package com.study.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //todo : @Cacheable 설정
@SpringBootApplication
public class StudyRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyRedisApplication.class, args);
    }

}
