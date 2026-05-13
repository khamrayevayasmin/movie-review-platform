package com.movie_review_platform.service.impl;

import com.movie_review_platform.dto.YasminReviewDto;
import com.movie_review_platform.dto.YasminReviewRequest;
import com.movie_review_platform.entity.YasminReview;
import com.movie_review_platform.mapper.YasminReviewMapper;
import com.movie_review_platform.repository.YasminMovieRepository;
import com.movie_review_platform.repository.YasminReviewRepository;
import com.movie_review_platform.repository.YasminUserRepository;
import com.movie_review_platform.service.YasminReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YasminReviewServiceImpl implements YasminReviewService {

    private final YasminReviewRepository reviewRepository;
    private final YasminMovieRepository movieRepository;
    private final YasminUserRepository userRepository;
    private final YasminReviewMapper reviewMapper;

    @Override
    public YasminReviewDto createReview(YasminReviewRequest request, String email) {
        YasminReview review = YasminReview.builder()
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
    public List<YasminReviewDto> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieId(movieId)
                .stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<YasminReviewDto> getReviewsByUser(Long userId) {
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