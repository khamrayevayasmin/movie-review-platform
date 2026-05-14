package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.KhamrayevaYasminGenreDto;
import com.movie_review_platform.entity.KhamrayevaYasminGenre;
import org.springframework.stereotype.Component;

@Component
public class KhamrayevaYasminGenreMapper {

    public KhamrayevaYasminGenreDto toDto(KhamrayevaYasminGenre genre) {
        return KhamrayevaYasminGenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

    public KhamrayevaYasminGenre toEntity(KhamrayevaYasminGenreDto dto) {
        return KhamrayevaYasminGenre.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}