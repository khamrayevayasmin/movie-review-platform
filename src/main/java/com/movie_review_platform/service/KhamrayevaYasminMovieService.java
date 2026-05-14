package com.movie_review_platform.service;

import com.movie_review_platform.dto.KhamrayevaYasminMovieDto;
import com.movie_review_platform.dto.KhamrayevaYasminMovieRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhamrayevaYasminMovieService {
    KhamrayevaYasminMovieDto createMovie(KhamrayevaYasminMovieRequest request);
    KhamrayevaYasminMovieDto getMovieById(Long id);
    Page<KhamrayevaYasminMovieDto> getAllMovies(String search, String genre, Pageable pageable);
    KhamrayevaYasminMovieDto updateMovie(Long id, KhamrayevaYasminMovieRequest request);
    void deleteMovie(Long id);
}