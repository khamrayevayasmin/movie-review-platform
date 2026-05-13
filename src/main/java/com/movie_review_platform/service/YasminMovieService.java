package com.movie_review_platform.service;

import com.movie_review_platform.dto.YasminMovieDto;
import com.movie_review_platform.dto.YasminMovieRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface YasminMovieService {
    YasminMovieDto createMovie(YasminMovieRequest request);
    YasminMovieDto getMovieById(Long id);
    Page<YasminMovieDto> getAllMovies(String search, String genre, Pageable pageable);
    YasminMovieDto updateMovie(Long id, YasminMovieRequest request);
    void deleteMovie(Long id);
}