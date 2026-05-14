package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.KhamrayevaYasminLoginRequest;
import com.movie_review_platform.dto.KhamrayevaYasminRegisterRequest;
import com.movie_review_platform.entity.Role;
import com.movie_review_platform.entity.KhamrayevaYasminUser;
import com.movie_review_platform.repository.KhamrayevaYasminUserRepository;
import com.movie_review_platform.security.KhamrayevaYasminJwtUtil;
import com.movie_review_platform.service.KhamrayevaYasminAsyncService;
import com.movie_review_platform.service.KhamrayevaYasminAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YasminAuthServiceImpl implements KhamrayevaYasminAuthService {

    private final KhamrayevaYasminUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final KhamrayevaYasminJwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final KhamrayevaYasminAsyncService asyncService;

    @Override
    public String register(KhamrayevaYasminRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        KhamrayevaYasminUser user = KhamrayevaYasminUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        userRepository.save(user);
        asyncService.sendWelcomeEmail(user.getEmail(), user.getFirstName());
        asyncService.logUserActivity(user.getEmail(), "USER_REGISTERED");
        return jwtUtil.generateToken(user.getEmail());
    }

    @Override
    public String login(KhamrayevaYasminLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        return jwtUtil.generateToken(request.getEmail());
    }
}