package com.movie_review_platform.controller;

import com.movie_review_platform.dto.YasminReviewDto;
import com.movie_review_platform.dto.YasminReviewRequest;
import com.movie_review_platform.service.YasminReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class YasminReviewController {

    private final YasminReviewService reviewService;

    @PostMapping
    public ResponseEntity<YasminReviewDto> createReview(
            @Valid @RequestBody YasminReviewRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(reviewService.createReview(request, userDetails.getUsername()));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<YasminReviewDto>> getReviewsByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(reviewService.getReviewsByMovie(movieId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<YasminReviewDto>> getReviewsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsByUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}