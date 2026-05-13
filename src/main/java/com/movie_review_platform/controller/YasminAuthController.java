package com.movie_review_platform.controller;

import com.movie_review_platform.dto.YasminLoginRequest;
import com.movie_review_platform.dto.YasminRegisterRequest;
import com.movie_review_platform.service.YasminAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class YasminAuthController {

    private final YasminAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody YasminRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody YasminLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}