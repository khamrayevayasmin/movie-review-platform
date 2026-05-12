package com.movie_review_platform.repository;

import com.movie_review_platform.entity.YasminReview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface YasminReviewRepository extends JpaRepository<YasminReview, Long> {
    List<YasminReview> findByMovieId(Long movieId);
    List<YasminReview> findByUserId(Long userId);
}