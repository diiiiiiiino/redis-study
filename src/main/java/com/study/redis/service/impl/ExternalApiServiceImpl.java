package com.study.redis.service.impl;

import com.study.redis.service.ExternalApiService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {
    @Override
    public String getUserName(String userId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getUserName start");

        if(userId.equals("A")){
            return "Adam";
        }

        if(userId.equals("B")){
            return "Bob";
        }

        return "";
    }

    @Override
    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getUserAge start");

        if(userId.equals("A")){
            return 28;
        }

        if(userId.equals("B")){
            return 32;
        }

        return 0;
    }
}
