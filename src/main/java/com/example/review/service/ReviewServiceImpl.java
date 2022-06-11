package com.example.review.service;

import com.example.review.model.Review;
import com.example.review.model.enums.ReviewStatus;
import com.example.review.repository.AverageAndCountOfReviews;
import com.example.review.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review save(Review review) {
        try {
            return this.reviewRepository.save(review);
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Optional<Review> getById(Long reviewId) {
        try {
            return this.reviewRepository.findById(reviewId);
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Review> getAllReviewsByProductId(Long productId) {
        try {
            return this.reviewRepository.findAllByProductId(productId);
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public LastThreeReviewForAProductModel getLast3viewsByProductId(Long productId) {
        try {
            List<Review> reviews = this.reviewRepository.getLastThreeReviews(productId);
            AverageAndCountOfReviews averageAndCountOfReviews = this.reviewRepository.getAverageAndCountOfReviews(productId);

            LastThreeReviewForAProductModel lastThreeReviewForAProductModel = new LastThreeReviewForAProductModel();
            lastThreeReviewForAProductModel.setReviews(reviews);
            lastThreeReviewForAProductModel.setReviewsCount(averageAndCountOfReviews.getReviewsCount());
            lastThreeReviewForAProductModel.setRateAverage(averageAndCountOfReviews.getAverage());

            return lastThreeReviewForAProductModel;
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Review updateStatusById(Long productId, Long reviewId, ReviewStatus status) {
        try {
            Optional<Review> review = this.reviewRepository.findReviewByProductIdAndId(productId, reviewId);
            review.get().setStatus(status);
            return this.reviewRepository.save(review.get());
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
