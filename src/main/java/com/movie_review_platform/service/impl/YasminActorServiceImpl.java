package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.YasminActorDto;
import com.movie_review_platform.entity.YasminActor;
import com.movie_review_platform.mapper.YasminActorMapper;
import com.movie_review_platform.repository.YasminActorRepository;
import com.movie_review_platform.service.YasminActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YasminActorServiceImpl implements YasminActorService {

    private final YasminActorRepository actorRepository;
    private final YasminActorMapper actorMapper;

    @Override
    public YasminActorDto createActor(YasminActorDto dto) {
        YasminActor actor = YasminActor.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .bio(dto.getBio())
                .photoUrl(dto.getPhotoUrl())
                .build();
        return actorMapper.toDto(actorRepository.save(actor));
    }

    @Override
    public YasminActorDto getActorById(Long id) {
        return actorRepository.findById(id)
                .map(actorMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
    }

    @Override
    public Page<YasminActorDto> getAllActors(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return actorRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                            search, search, pageable)
                    .map(actorMapper::toDto);
        }
        return actorRepository.findAll(pageable).map(actorMapper::toDto);
    }

    @Override
    public YasminActorDto updateActor(Long id, YasminActorDto dto) {
        YasminActor actor = actorRepository.findById(id)
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