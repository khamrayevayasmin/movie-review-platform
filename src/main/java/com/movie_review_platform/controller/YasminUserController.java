package com.movie_review_platform.controller;

import com.movie_review_platform.dto.YasminUserDto;
import com.movie_review_platform.mapper.YasminUserMapper;
import com.movie_review_platform.repository.YasminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class YasminUserController {

    private final YasminUserRepository userRepository;
    private final YasminUserMapper userMapper;

    @GetMapping("/me")
    public ResponseEntity<YasminUserDto> getCurrentUser(
            @AuthenticationPrincipal UserDetails userDetails) {
        return userRepository.findByEmail(userDetails.getUsername())
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public ResponseEntity<List<YasminUserDto>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList()));
    }
}