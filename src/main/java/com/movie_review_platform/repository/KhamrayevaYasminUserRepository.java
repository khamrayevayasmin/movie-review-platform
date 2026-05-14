package com.movie_review_platform.repository;

import com.movie_review_platform.entity.KhamrayevaYasminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface KhamrayevaYasminUserRepository extends JpaRepository<KhamrayevaYasminUser, Long> {
    Optional<KhamrayevaYasminUser> findByEmail(String email);
    boolean existsByEmail(String email);
}