package com.movie_review_platform.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhamrayevaYasminReviewDto {
    private Long id;
    private Integer rating;
    private String content;
    private LocalDateTime createdAt;
    private String userName;
    private String movieTitle;
}