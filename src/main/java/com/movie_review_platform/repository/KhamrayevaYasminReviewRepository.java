package com.movie_review_platform.repository;

import com.movie_review_platform.entity.KhamrayevaYasminReview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KhamrayevaYasminReviewRepository extends JpaRepository<KhamrayevaYasminReview, Long> {
    List<KhamrayevaYasminReview> findByMovieId(Long movieId);
    List<KhamrayevaYasminReview> findByUserId(Long userId);
}