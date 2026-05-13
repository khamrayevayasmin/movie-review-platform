package com.movie_review_platform.controller;

import com.movie_review_platform.dto.YasminGenreDto;
import com.movie_review_platform.service.YasminGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class YasminGenreController {

    private final YasminGenreService genreService;

    @PostMapping
    public ResponseEntity<YasminGenreDto> createGenre(@RequestBody YasminGenreDto dto) {
        return ResponseEntity.ok(genreService.createGenre(dto));
    }

    @GetMapping
    public ResponseEntity<List<YasminGenreDto>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @PutMapping("/{id}")
    public ResponseEntity<YasminGenreDto> updateGenre(@PathVariable Long id,
                                                      @RequestBody YasminGenreDto dto) {
        return ResponseEntity.ok(genreService.updateGenre(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}