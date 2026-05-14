package com.movie_review_platform.service;

import com.movie_review_platform.dto.KhamrayevaYasminLoginRequest;
import com.movie_review_platform.dto.KhamrayevaYasminRegisterRequest;

public interface KhamrayevaYasminAuthService {
    String register(KhamrayevaYasminRegisterRequest request);
    String login(KhamrayevaYasminLoginRequest request);
}