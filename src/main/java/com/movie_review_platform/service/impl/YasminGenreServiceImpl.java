package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.YasminGenreDto;
import com.movie_review_platform.entity.YasminGenre;
import com.movie_review_platform.mapper.YasminGenreMapper;
import com.movie_review_platform.repository.YasminGenreRepository;
import com.movie_review_platform.service.YasminGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YasminGenreServiceImpl implements YasminGenreService {

    private final YasminGenreRepository genreRepository;
    private final YasminGenreMapper genreMapper;

    @Override
    public YasminGenreDto createGenre(YasminGenreDto dto) {
        YasminGenre genre = YasminGenre.builder()
                .name(dto.getName())
                .build();
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Override
    public List<YasminGenreDto> getAllGenres() {
        return genreRepository.findAll()
                .stream()
                .map(genreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public YasminGenreDto updateGenre(Long id, YasminGenreDto dto) {
        YasminGenre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.setName(dto.getName());
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}