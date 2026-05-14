package com.movie_review_platform.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class KhamrayevaYasminAsyncService {

    @Async
    public CompletableFuture<Void> sendWelcomeEmail(String email, String firstName) {
        log.info("Sending welcome email to: {}", email);
        try {
            Thread.sleep(2000);
            log.info("Welcome email sent successfully to: {} ({})", firstName, email);
        } catch (InterruptedException e) {
            log.error("Error sending email to: {}", email);
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async
    public CompletableFuture<Double> calculateAverageRating(Long movieId,
                                                            java.util.List<Integer> ratings) {
        log.info("Calculating average rating for movie ID: {}", movieId);
        try {
            Thread.sleep(1000);
            double average = ratings.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            log.info("Average rating for movie {}: {}", movieId, average);
            return CompletableFuture.completedFuture(average);
        } catch (InterruptedException e) {
            log.error("Error calculating rating for movie: {}", movieId);
            Thread.currentThread().interrupt();
            return CompletableFuture.completedFuture(0.0);
        }
    }

    @Async
    public CompletableFuture<Void> logUserActivity(String email, String action) {
        log.info("User activity - Email: {}, Action: {}", email, action);
        return CompletableFuture.completedFuture(null);
    }
}