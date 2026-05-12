package com.movie_review_platform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YasminActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String photoUrl;
}