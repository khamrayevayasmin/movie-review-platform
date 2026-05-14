package com.movie_review_platform.controller;

import com.movie_review_platform.dto.KhamrayevaYasminGenreDto;
import com.movie_review_platform.service.KhamrayevaYasminGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class KhamrayevaYasminGenreController {

    private final KhamrayevaYasminGenreService genreService;

    @PostMapping
    public ResponseEntity<KhamrayevaYasminGenreDto> createGenre(@RequestBody KhamrayevaYasminGenreDto dto) {
        return ResponseEntity.ok(genreService.createGenre(dto));
    }

    @GetMapping
    public ResponseEntity<List<KhamrayevaYasminGenreDto>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhamrayevaYasminGenreDto> updateGenre(@PathVariable Long id,
                                                                @RequestBody KhamrayevaYasminGenreDto dto) {
        return ResponseEntity.ok(genreService.updateGenre(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}