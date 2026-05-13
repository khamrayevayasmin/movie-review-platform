package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.YasminMovieDto;
import com.movie_review_platform.entity.YasminMovie;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class YasminMovieMapper {

    public YasminMovieDto toDto(YasminMovie movie) {
        return YasminMovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseYear(movie.getReleaseYear())
                .duration(movie.getDuration())
                .posterUrl(movie.getPosterUrl())
                .genres(movie.getGenres() != null ?
                        movie.getGenres().stream()
                                .map(g -> g.getName())
                                .collect(Collectors.toList()) : null)
                .actors(movie.getActors() != null ?
                        movie.getActors().stream()
                                .map(a -> a.getFirstName() + " " + a.getLastName())
                                .collect(Collectors.toList()) : null)
                .build();
    }
}