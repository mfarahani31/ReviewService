package com.example.review;

import com.example.review.model.Review;
import com.example.review.model.enums.ReviewStatus;

import java.util.ArrayList;
import java.util.List;

public class MotherObject {
    public static Review getAnyReview() {
        return new Review("So good!!!", 3, ReviewStatus.CONFIRMED, 1L, 1L);
    }

    public static List<Review> getAnyListOfReviews() {
        Review review1 = new Review("So good!!!", 3, ReviewStatus.CONFIRMED, 1L, 1L);
        Review review2 = new Review("Bad", 1, ReviewStatus.REJECTED, 1L, 1L);
        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);
        return reviews;
    }
}
