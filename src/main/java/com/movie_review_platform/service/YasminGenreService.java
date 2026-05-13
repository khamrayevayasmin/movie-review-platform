package com.movie_review_platform.service;

import com.movie_review_platform.dto.YasminGenreDto;
import java.util.List;

public interface YasminGenreService {
    YasminGenreDto createGenre(YasminGenreDto dto);
    List<YasminGenreDto> getAllGenres();
    YasminGenreDto updateGenre(Long id, YasminGenreDto dto);
    void deleteGenre(Long id);
}