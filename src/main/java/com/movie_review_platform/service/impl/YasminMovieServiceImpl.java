package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.YasminMovieDto;
import com.movie_review_platform.dto.YasminMovieRequest;
import com.movie_review_platform.entity.YasminMovie;
import com.movie_review_platform.mapper.YasminMovieMapper;
import com.movie_review_platform.repository.YasminActorRepository;
import com.movie_review_platform.repository.YasminGenreRepository;
import com.movie_review_platform.repository.YasminMovieRepository;
import com.movie_review_platform.service.YasminMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YasminMovieServiceImpl implements YasminMovieService {

    private final YasminMovieRepository movieRepository;
    private final YasminGenreRepository genreRepository;
    private final YasminActorRepository actorRepository;
    private final YasminMovieMapper movieMapper;

    @Override
    public YasminMovieDto createMovie(YasminMovieRequest request) {
        YasminMovie movie = YasminMovie.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .releaseYear(request.getReleaseYear())
                .duration(request.getDuration())
                .genres(request.getGenreIds() != null ?
                        genreRepository.findAllById(request.getGenreIds()) : null)
                .actors(request.getActorIds() != null ?
                        actorRepository.findAllById(request.getActorIds()) : null)
                .build();
        return movieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public YasminMovieDto getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public Page<YasminMovieDto> getAllMovies(String search, String genre, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return movieRepository
                    .findByTitleContainingIgnoreCase(search, pageable)
                    .map(movieMapper::toDto);
        }
        if (genre != null && !genre.isEmpty()) {
            return movieRepository
                    .findByGenres_Name(genre, pageable)
                    .map(movieMapper::toDto);
        }
        return movieRepository.findAll(pageable).map(movieMapper::toDto);
    }

    @Override
    public YasminMovieDto updateMovie(Long id, YasminMovieRequest request) {
        YasminMovie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setDuration(request.getDuration());
        if (request.getGenreIds() != null) {
            movie.setGenres(genreRepository.findAllById(request.getGenreIds()));
        }
        if (request.getActorIds() != null) {
            movie.setActors(actorRepository.findAllById(request.getActorIds()));
        }
        return movieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}