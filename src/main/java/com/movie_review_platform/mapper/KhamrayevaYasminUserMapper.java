package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.KhamrayevaYasminUserDto;
import com.movie_review_platform.entity.KhamrayevaYasminUser;
import org.springframework.stereotype.Component;

@Component
public class KhamrayevaYasminUserMapper {

    public KhamrayevaYasminUserDto toDto(KhamrayevaYasminUser user) {
        return KhamrayevaYasminUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}