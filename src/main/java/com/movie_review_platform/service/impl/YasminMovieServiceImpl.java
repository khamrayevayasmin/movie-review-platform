package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.KhamrayevaYasminMovieDto;
import com.movie_review_platform.dto.KhamrayevaYasminMovieRequest;
import com.movie_review_platform.entity.KhamrayevaYasminMovie;
import com.movie_review_platform.mapper.KhamrayevaYasminMovieMapper;
import com.movie_review_platform.repository.KhamrayevaYasminActorRepository;
import com.movie_review_platform.repository.KhamrayevaYasminGenreRepository;
import com.movie_review_platform.repository.KhamrayevaYasminMovieRepository;
import com.movie_review_platform.service.KhamrayevaYasminMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YasminMovieServiceImpl implements KhamrayevaYasminMovieService {

    private final KhamrayevaYasminMovieRepository movieRepository;
    private final KhamrayevaYasminGenreRepository genreRepository;
    private final KhamrayevaYasminActorRepository actorRepository;
    private final KhamrayevaYasminMovieMapper movieMapper;

    @Override
    public KhamrayevaYasminMovieDto createMovie(KhamrayevaYasminMovieRequest request) {
        KhamrayevaYasminMovie movie = KhamrayevaYasminMovie.builder()
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
    public KhamrayevaYasminMovieDto getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public Page<KhamrayevaYasminMovieDto> getAllMovies(String search, String genre, Pageable pageable) {
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
    public KhamrayevaYasminMovieDto updateMovie(Long id, KhamrayevaYasminMovieRequest request) {
        KhamrayevaYasminMovie movie = movieRepository.findById(id)
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