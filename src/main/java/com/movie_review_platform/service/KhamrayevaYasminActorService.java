package com.movie_review_platform.service;

import com.movie_review_platform.dto.KhamrayevaYasminActorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhamrayevaYasminActorService {
    KhamrayevaYasminActorDto createActor(KhamrayevaYasminActorDto dto);
    KhamrayevaYasminActorDto getActorById(Long id);
    Page<KhamrayevaYasminActorDto> getAllActors(String search, Pageable pageable);
    KhamrayevaYasminActorDto updateActor(Long id, KhamrayevaYasminActorDto dto);
    void deleteActor(Long id);
}