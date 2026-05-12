package com.movie_review_platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YasminReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private YasminUser user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private YasminMovie movie;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}