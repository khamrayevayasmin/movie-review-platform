package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.KhamrayevaYasminReviewDto;
import com.movie_review_platform.dto.KhamrayevaYasminReviewRequest;
import com.movie_review_platform.entity.KhamrayevaYasminReview;
import com.movie_review_platform.mapper.KhamrayevaYasminReviewMapper;
import com.movie_review_platform.repository.KhamrayevaYasminMovieRepository;
import com.movie_review_platform.repository.KhamrayevaYasminReviewRepository;
import com.movie_review_platform.repository.KhamrayevaYasminUserRepository;
import com.movie_review_platform.service.KhamrayevaYasminReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YasminReviewServiceImpl implements KhamrayevaYasminReviewService {

    private final KhamrayevaYasminReviewRepository reviewRepository;
    private final KhamrayevaYasminMovieRepository movieRepository;
    private final KhamrayevaYasminUserRepository userRepository;
    private final KhamrayevaYasminReviewMapper reviewMapper;

    @Override
    public KhamrayevaYasminReviewDto createReview(KhamrayevaYasminReviewRequest request, String email) {
        KhamrayevaYasminReview review = KhamrayevaYasminReview.builder()
                .rating(request.getRating())
                .content(request.getContent())
                .movie(movieRepository.findById(request.getMovieId())
                        .orElseThrow(() -> new RuntimeException("Movie not found")))
                .user(userRepository.findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("User not found")))
                .build();
        return reviewMapper.toDto(reviewRepository.save(review));
    }

    @Override
    public List<KhamrayevaYasminReviewDto> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieId(movieId)
                .stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<KhamrayevaYasminReviewDto> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId)
                .stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}