package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.YasminLoginRequest;
import com.movie_review_platform.dto.YasminRegisterRequest;
import com.movie_review_platform.entity.Role;
import com.movie_review_platform.entity.YasminUser;
import com.movie_review_platform.repository.YasminUserRepository;
import com.movie_review_platform.security.YasminJwtUtil;
import com.movie_review_platform.service.YasminAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YasminAuthServiceImpl implements YasminAuthService {

    private final YasminUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final YasminJwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(YasminRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        YasminUser user = YasminUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        userRepository.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    @Override
    public String login(YasminLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        return jwtUtil.generateToken(request.getEmail());
    }
}