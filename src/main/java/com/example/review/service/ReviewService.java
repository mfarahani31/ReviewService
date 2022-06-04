package com.example.review.service;

import com.example.review.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review save(Review review);
    Optional<Review> getById(Long reviewId);
    List<Review> getAll();
    LastThreeReviewForAProductModel getLast3viewsByProductId(Long productId);
}
