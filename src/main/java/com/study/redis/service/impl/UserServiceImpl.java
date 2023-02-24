package com.study.redis.service.impl;

import com.study.redis.dto.UserProfile;
import com.study.redis.service.ExternalApiService;
import com.study.redis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ExternalApiService externalApiService;

    private final StringRedisTemplate redisTemplate;

    @Override
    public UserProfile getUserProfile(String userId) {
        //Cache-Aside Pattern
        String userName = null;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String cachedName = ops.get("nameKey:" + userId);
        if(cachedName != null){
            userName = cachedName;
        } else {
            userName = externalApiService.getUserName(userId);
            ops.set("nameKey:" + userId, userName, 5, TimeUnit.SECONDS);
        }

        int userAge = externalApiService.getUserAge(userId);
        return new UserProfile(userName, userAge);
    }
}
