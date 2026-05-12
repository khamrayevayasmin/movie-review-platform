package com.movie_review_platform.repository;

import com.movie_review_platform.entity.YasminMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface YasminMovieRepository extends JpaRepository<YasminMovie, Long> {
    Page<YasminMovie> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<YasminMovie> findByGenres_Name(String genreName, Pageable pageable);
}