package com.movie_review_platform.controller;

import com.movie_review_platform.dto.KhamrayevaYasminActorDto;
import com.movie_review_platform.service.KhamrayevaYasminActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
public class KhamrayevaYasminActorController {

    private final KhamrayevaYasminActorService actorService;

    @PostMapping
    public ResponseEntity<KhamrayevaYasminActorDto> createActor(@RequestBody KhamrayevaYasminActorDto dto) {
        return ResponseEntity.ok(actorService.createActor(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhamrayevaYasminActorDto> getActorById(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.getActorById(id));
    }

    @GetMapping
    public ResponseEntity<Page<KhamrayevaYasminActorDto>> getAllActors(
            @RequestParam(required = false) String search,
            Pageable pageable) {
        return ResponseEntity.ok(actorService.getAllActors(search, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhamrayevaYasminActorDto> updateActor(@PathVariable Long id,
                                                                @RequestBody KhamrayevaYasminActorDto dto) {
        return ResponseEntity.ok(actorService.updateActor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}