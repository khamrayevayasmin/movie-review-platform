package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.KhamrayevaYasminGenreDto;
import com.movie_review_platform.entity.KhamrayevaYasminGenre;
import com.movie_review_platform.mapper.KhamrayevaYasminGenreMapper;
import com.movie_review_platform.repository.KhamrayevaYasminGenreRepository;
import com.movie_review_platform.service.KhamrayevaYasminGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KhamrayevaYasminGenreServiceImpl implements KhamrayevaYasminGenreService {

    private final KhamrayevaYasminGenreRepository genreRepository;
    private final KhamrayevaYasminGenreMapper genreMapper;

    @Override
    public KhamrayevaYasminGenreDto createGenre(KhamrayevaYasminGenreDto dto) {
        KhamrayevaYasminGenre genre = KhamrayevaYasminGenre.builder()
                .name(dto.getName())
                .build();
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Override
    public List<KhamrayevaYasminGenreDto> getAllGenres() {
        return genreRepository.findAll()
                .stream()
                .map(genreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KhamrayevaYasminGenreDto updateGenre(Long id, KhamrayevaYasminGenreDto dto) {
        KhamrayevaYasminGenre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.setName(dto.getName());
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}