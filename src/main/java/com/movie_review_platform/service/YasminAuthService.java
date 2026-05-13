package com.movie_review_platform.service;

import com.movie_review_platform.dto.YasminLoginRequest;
import com.movie_review_platform.dto.YasminRegisterRequest;

public interface YasminAuthService {
    String register(YasminRegisterRequest request);
    String login(YasminLoginRequest request);
}