package com.movie_review_platform.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YasminUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}