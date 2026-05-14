package com.movie_review_platform.controller;

import com.movie_review_platform.dto.KhamrayevaYasminLoginRequest;
import com.movie_review_platform.dto.KhamrayevaYasminRegisterRequest;
import com.movie_review_platform.service.KhamrayevaYasminAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class KhamrayevaYasminAuthController {

    private final KhamrayevaYasminAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody KhamrayevaYasminRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody KhamrayevaYasminLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}