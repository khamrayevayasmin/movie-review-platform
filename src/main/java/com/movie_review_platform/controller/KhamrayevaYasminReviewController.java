package com.movie_review_platform.controller;

import com.movie_review_platform.dto.KhamrayevaYasminReviewDto;
import com.movie_review_platform.dto.KhamrayevaYasminReviewRequest;
import com.movie_review_platform.service.KhamrayevaYasminReviewService;
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
public class KhamrayevaYasminReviewController {

    private final KhamrayevaYasminReviewService reviewService;

    @PostMapping
    public ResponseEntity<KhamrayevaYasminReviewDto> createReview(
            @Valid @RequestBody KhamrayevaYasminReviewRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(reviewService.createReview(request, userDetails.getUsername()));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<KhamrayevaYasminReviewDto>> getReviewsByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(reviewService.getReviewsByMovie(movieId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<KhamrayevaYasminReviewDto>> getReviewsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsByUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}