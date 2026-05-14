package com.movie_review_platform.repository;

import com.movie_review_platform.entity.KhamrayevaYasminMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhamrayevaYasminMovieRepository extends JpaRepository<KhamrayevaYasminMovie, Long> {
    Page<KhamrayevaYasminMovie> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<KhamrayevaYasminMovie> findByGenres_Name(String genreName, Pageable pageable);
}