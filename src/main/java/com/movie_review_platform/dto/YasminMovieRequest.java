package com.movie_review_platform.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YasminMovieRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Release year is required")
    private Integer releaseYear;

    private Integer duration;

    private List<Long> genreIds;

    private List<Long> actorIds;
}