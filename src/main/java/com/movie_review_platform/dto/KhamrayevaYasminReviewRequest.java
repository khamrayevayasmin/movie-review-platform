package com.movie_review_platform.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhamrayevaYasminReviewRequest {

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 10, message = "Rating must be at most 10")
    private Integer rating;

    @NotBlank(message = "Content is required")
    private String content;

    @NotNull(message = "Movie ID is required")
    private Long movieId;
}