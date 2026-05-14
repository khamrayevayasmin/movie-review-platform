package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.KhamrayevaYasminActorDto;
import com.movie_review_platform.entity.KhamrayevaYasminActor;
import org.springframework.stereotype.Component;

@Component
public class KhamrayevaYasminActorMapper {

    public KhamrayevaYasminActorDto toDto(KhamrayevaYasminActor actor) {
        return KhamrayevaYasminActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .bio(actor.getBio())
                .photoUrl(actor.getPhotoUrl())
                .build();
    }

    public KhamrayevaYasminActor toEntity(KhamrayevaYasminActorDto dto) {
        return KhamrayevaYasminActor.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .bio(dto.getBio())
                .photoUrl(dto.getPhotoUrl())
                .build();
    }
}