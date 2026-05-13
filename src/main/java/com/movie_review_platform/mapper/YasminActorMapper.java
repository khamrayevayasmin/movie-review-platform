package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.YasminActorDto;
import com.movie_review_platform.entity.YasminActor;
import org.springframework.stereotype.Component;

@Component
public class YasminActorMapper {

    public YasminActorDto toDto(YasminActor actor) {
        return YasminActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .bio(actor.getBio())
                .photoUrl(actor.getPhotoUrl())
                .build();
    }

    public YasminActor toEntity(YasminActorDto dto) {
        return YasminActor.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .bio(dto.getBio())
                .photoUrl(dto.getPhotoUrl())
                .build();
    }
}