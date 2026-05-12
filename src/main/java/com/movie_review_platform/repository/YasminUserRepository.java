package com.movie_review_platform.repository;

import com.movie_review_platform.entity.YasminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface YasminUserRepository extends JpaRepository<YasminUser, Long> {
    Optional<YasminUser> findByEmail(String email);
    boolean existsByEmail(String email);
}