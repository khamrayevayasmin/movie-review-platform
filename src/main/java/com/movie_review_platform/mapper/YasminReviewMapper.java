package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.YasminReviewDto;
import com.movie_review_platform.entity.YasminReview;
import org.springframework.stereotype.Component;

@Component
public class YasminReviewMapper {

    public YasminReviewDto toDto(YasminReview review) {
        return YasminReviewDto.builder()
                .id(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .userName(review.getUser().getFirstName() + " " + review.getUser().getLastName())
                .movieTitle(review.getMovie().getTitle())
                .build();
    }
}