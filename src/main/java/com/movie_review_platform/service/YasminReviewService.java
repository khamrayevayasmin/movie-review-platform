package com.movie_review_platform.service;

import com.movie_review_platform.dto.YasminReviewDto;
import com.movie_review_platform.dto.YasminReviewRequest;
import java.util.List;

public interface YasminReviewService {
    YasminReviewDto createReview(YasminReviewRequest request, String email);
    List<YasminReviewDto> getReviewsByMovie(Long movieId);
    List<YasminReviewDto> getReviewsByUser(Long userId);
    void deleteReview(Long id);
}