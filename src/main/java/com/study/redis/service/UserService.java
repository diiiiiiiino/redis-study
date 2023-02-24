package com.study.redis.service;

import com.study.redis.dto.UserProfile;

public interface UserService {
    UserProfile getUserProfile(String userId);
}
