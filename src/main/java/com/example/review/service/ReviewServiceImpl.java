package com.example.review.service;

import com.example.review.model.Review;
import com.example.review.model.enums.ReviewStatus;
import com.example.review.repository.AverageAndCountOfReviews;
import com.example.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getById(Long reviewId) {
        return this.reviewRepository.findById(reviewId);
    }

    @Override
    public List<Review> getAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public LastThreeReviewForAProductModel getLast3viewsByProductId(Long productId) {
        List<Review> reviews = this.reviewRepository.getLastThreeReviews(productId);
        AverageAndCountOfReviews averageAndCountOfReviews = this.reviewRepository.getAverageAndCountOfReviews(productId);

        LastThreeReviewForAProductModel lastThreeReviewForAProductModel = new LastThreeReviewForAProductModel();
        lastThreeReviewForAProductModel.setReviews(reviews);
        lastThreeReviewForAProductModel.setReviewsCount(averageAndCountOfReviews.getReviewsCount());
        lastThreeReviewForAProductModel.setRateAverage(averageAndCountOfReviews.getAverage());

        return lastThreeReviewForAProductModel;
    }

    @Override
    public Review updateStatusById(Long reviewId, ReviewStatus status) {
        Optional<Review> review = this.reviewRepository.findById(reviewId);
        review.get().setStatus(status);

        return this.reviewRepository.save(review.get());
    }
}
