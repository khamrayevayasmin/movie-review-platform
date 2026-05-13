package com.movie_review_platform.controller;

import com.movie_review_platform.dto.YasminMovieDto;
import com.movie_review_platform.dto.YasminMovieRequest;
import com.movie_review_platform.service.YasminMovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class YasminMovieController {

    private final YasminMovieService movieService;

    @PostMapping
    public ResponseEntity<YasminMovieDto> createMovie(@Valid @RequestBody YasminMovieRequest request) {
        return ResponseEntity.ok(movieService.createMovie(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<YasminMovieDto> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<Page<YasminMovieDto>> getAllMovies(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String genre,
            Pageable pageable) {
        return ResponseEntity.ok(movieService.getAllMovies(search, genre, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<YasminMovieDto> updateMovie(@PathVariable Long id,
                                                      @Valid @RequestBody YasminMovieRequest request) {
        return ResponseEntity.ok(movieService.updateMovie(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}