package com.example.review.service;

import com.example.review.model.Review;
import com.example.review.model.enums.ReviewStatus;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review save(Review review);

    Optional<Review> getById(Long reviewId);

    List<Review> getAllReviewsByProductId(Long productId);

    LastThreeReviewForAProductModel getLast3viewsByProductId(Long productId);

    Review updateStatusById(Long productId, Long reviewId, ReviewStatus status);
}
