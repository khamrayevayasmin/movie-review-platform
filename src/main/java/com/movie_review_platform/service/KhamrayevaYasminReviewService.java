package com.movie_review_platform.service;

import com.movie_review_platform.dto.KhamrayevaYasminReviewDto;
import com.movie_review_platform.dto.KhamrayevaYasminReviewRequest;
import java.util.List;

public interface KhamrayevaYasminReviewService {
    KhamrayevaYasminReviewDto createReview(KhamrayevaYasminReviewRequest request, String email);
    List<KhamrayevaYasminReviewDto> getReviewsByMovie(Long movieId);
    List<KhamrayevaYasminReviewDto> getReviewsByUser(Long userId);
    void deleteReview(Long id);
}