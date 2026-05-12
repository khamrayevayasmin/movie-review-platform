package com.movie_review_platform.repository;

import com.movie_review_platform.entity.YasminGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface YasminGenreRepository extends JpaRepository<YasminGenre, Long> {
    Optional<YasminGenre> findByName(String name);
}