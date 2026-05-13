package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.YasminGenreDto;
import com.movie_review_platform.entity.YasminGenre;
import org.springframework.stereotype.Component;

@Component
public class YasminGenreMapper {

    public YasminGenreDto toDto(YasminGenre genre) {
        return YasminGenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

    public YasminGenre toEntity(YasminGenreDto dto) {
        return YasminGenre.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}