package com.movie_review_platform.repository;

import com.movie_review_platform.entity.KhamrayevaYasminActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhamrayevaYasminActorRepository extends JpaRepository<KhamrayevaYasminActor, Long> {
    Page<KhamrayevaYasminActor> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName, Pageable pageable);
}