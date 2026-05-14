package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.KhamrayevaYasminReviewDto;
import com.movie_review_platform.entity.KhamrayevaYasminReview;
import org.springframework.stereotype.Component;

@Component
public class KhamrayevaYasminReviewMapper {

    public KhamrayevaYasminReviewDto toDto(KhamrayevaYasminReview review) {
        return KhamrayevaYasminReviewDto.builder()
                .id(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .userName(review.getUser().getFirstName() + " " + review.getUser().getLastName())
                .movieTitle(review.getMovie().getTitle())
                .build();
    }
}