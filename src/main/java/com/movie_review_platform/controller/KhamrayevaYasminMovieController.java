package com.movie_review_platform.controller;

import com.movie_review_platform.dto.KhamrayevaYasminMovieDto;
import com.movie_review_platform.dto.KhamrayevaYasminMovieRequest;
import com.movie_review_platform.service.KhamrayevaYasminMovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class KhamrayevaYasminMovieController {

    private final KhamrayevaYasminMovieService movieService;

    @PostMapping
    public ResponseEntity<KhamrayevaYasminMovieDto> createMovie(@Valid @RequestBody KhamrayevaYasminMovieRequest request) {
        return ResponseEntity.ok(movieService.createMovie(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhamrayevaYasminMovieDto> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<Page<KhamrayevaYasminMovieDto>> getAllMovies(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(movieService.getAllMovies(search, genre, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhamrayevaYasminMovieDto> updateMovie(@PathVariable Long id,
                                                                @Valid @RequestBody KhamrayevaYasminMovieRequest request) {
        return ResponseEntity.ok(movieService.updateMovie(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}