package com.movie_review_platform.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YasminMovieDto {
    private Long id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer duration;
    private String posterUrl;
    private List<String> genres;
    private List<String> actors;
}