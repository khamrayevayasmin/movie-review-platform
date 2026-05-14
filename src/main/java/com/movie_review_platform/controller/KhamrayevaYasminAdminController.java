package com.movie_review_platform.controller;

import com.movie_review_platform.dto.KhamrayevaYasminUserDto;
import com.movie_review_platform.mapper.KhamrayevaYasminUserMapper;
import com.movie_review_platform.repository.KhamrayevaYasminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class KhamrayevaYasminAdminController {

    private final KhamrayevaYasminUserRepository userRepository;
    private final KhamrayevaYasminUserMapper userMapper;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<KhamrayevaYasminUserDto>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}