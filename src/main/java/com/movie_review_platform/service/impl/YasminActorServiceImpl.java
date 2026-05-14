package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.KhamrayevaYasminActorDto;
import com.movie_review_platform.entity.KhamrayevaYasminActor;
import com.movie_review_platform.mapper.KhamrayevaYasminActorMapper;
import com.movie_review_platform.repository.KhamrayevaYasminActorRepository;
import com.movie_review_platform.service.KhamrayevaYasminActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YasminActorServiceImpl implements KhamrayevaYasminActorService {

    private final KhamrayevaYasminActorRepository actorRepository;
    private final KhamrayevaYasminActorMapper actorMapper;

    @Override
    public KhamrayevaYasminActorDto createActor(KhamrayevaYasminActorDto dto) {
        KhamrayevaYasminActor actor = KhamrayevaYasminActor.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .bio(dto.getBio())
                .photoUrl(dto.getPhotoUrl())
                .build();
        return actorMapper.toDto(actorRepository.save(actor));
    }

    @Override
    public KhamrayevaYasminActorDto getActorById(Long id) {
        return actorRepository.findById(id)
                .map(actorMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
    }

    @Override
    public Page<KhamrayevaYasminActorDto> getAllActors(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return actorRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                            search, search, pageable)
                    .map(actorMapper::toDto);
        }
        return actorRepository.findAll(pageable).map(actorMapper::toDto);
    }

    @Override
    public KhamrayevaYasminActorDto updateActor(Long id, KhamrayevaYasminActorDto dto) {
        KhamrayevaYasminActor actor = actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
        actor.setFirstName(dto.getFirstName());
        actor.setLastName(dto.getLastName());
        actor.setBio(dto.getBio());
        actor.setPhotoUrl(dto.getPhotoUrl());
        return actorMapper.toDto(actorRepository.save(actor));
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}