package com.movie_review_platform.mapper;

import com.movie_review_platform.dto.YasminUserDto;
import com.movie_review_platform.entity.YasminUser;
import org.springframework.stereotype.Component;

@Component
public class YasminUserMapper {

    public YasminUserDto toDto(YasminUser user) {
        return YasminUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}