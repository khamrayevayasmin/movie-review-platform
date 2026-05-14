package com.movie_review_platform.service;

import com.movie_review_platform.dto.KhamrayevaYasminGenreDto;
import java.util.List;

public interface KhamrayevaYasminGenreService {
    KhamrayevaYasminGenreDto createGenre(KhamrayevaYasminGenreDto dto);
    List<KhamrayevaYasminGenreDto> getAllGenres();
    KhamrayevaYasminGenreDto updateGenre(Long id, KhamrayevaYasminGenreDto dto);
    void deleteGenre(Long id);
}