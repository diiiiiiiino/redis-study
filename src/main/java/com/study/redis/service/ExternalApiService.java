package com.study.redis.service;

public interface ExternalApiService {
    String getUserName(String userId);
    int getUserAge(String userId);
}
