package com.movie_review_platform.repository;

import com.movie_review_platform.entity.KhamrayevaYasminGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface KhamrayevaYasminGenreRepository extends JpaRepository<KhamrayevaYasminGenre, Long> {
    Optional<KhamrayevaYasminGenre> findByName(String name);
}