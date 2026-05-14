package com.movie_review_platform.controller;

import com.movie_review_platform.dto.KhamrayevaYasminUserDto;
import com.movie_review_platform.mapper.KhamrayevaYasminUserMapper;
import com.movie_review_platform.repository.KhamrayevaYasminUserRepository;
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
public class KhamrayevaYasminUserController {

    private final KhamrayevaYasminUserRepository userRepository;
    private final KhamrayevaYasminUserMapper userMapper;

    @GetMapping("/me")
    public ResponseEntity<KhamrayevaYasminUserDto> getCurrentUser(
            @AuthenticationPrincipal UserDetails userDetails) {
        return userRepository.findByEmail(userDetails.getUsername())
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public ResponseEntity<List<KhamrayevaYasminUserDto>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList()));
    }
}