package com.movie_review_platform.repository;

import com.movie_review_platform.entity.YasminActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface YasminActorRepository extends JpaRepository<YasminActor, Long> {
    Page<YasminActor> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName, Pageable pageable);
}