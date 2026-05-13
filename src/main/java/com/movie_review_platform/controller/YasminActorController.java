package com.movie_review_platform.controller;

import com.movie_review_platform.dto.YasminActorDto;
import com.movie_review_platform.service.YasminActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
public class YasminActorController {

    private final YasminActorService actorService;

    @PostMapping
    public ResponseEntity<YasminActorDto> createActor(@RequestBody YasminActorDto dto) {
        return ResponseEntity.ok(actorService.createActor(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<YasminActorDto> getActorById(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.getActorById(id));
    }

    @GetMapping
    public ResponseEntity<Page<YasminActorDto>> getAllActors(
            @RequestParam(required = false) String search,
            Pageable pageable) {
        return ResponseEntity.ok(actorService.getAllActors(search, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<YasminActorDto> updateActor(@PathVariable Long id,
                                                      @RequestBody YasminActorDto dto) {
        return ResponseEntity.ok(actorService.updateActor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}