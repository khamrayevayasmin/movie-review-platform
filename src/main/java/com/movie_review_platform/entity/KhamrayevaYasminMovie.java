package com.movie_review_platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhamrayevaYasminMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer releaseYear;

    private Integer duration;

    private String posterUrl;

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<KhamrayevaYasminGenre> genres;

    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<KhamrayevaYasminActor> actors;
}