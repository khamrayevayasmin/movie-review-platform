package com.movie_review_platform.service;

import com.movie_review_platform.dto.YasminActorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface YasminActorService {
    YasminActorDto createActor(YasminActorDto dto);
    YasminActorDto getActorById(Long id);
    Page<YasminActorDto> getAllActors(String search, Pageable pageable);
    YasminActorDto updateActor(Long id, YasminActorDto dto);
    void deleteActor(Long id);
}