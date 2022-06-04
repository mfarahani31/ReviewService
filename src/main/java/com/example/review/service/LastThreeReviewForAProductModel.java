package com.example.review.service;

import com.example.review.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastThreeReviewForAProductModel {
    private List<Review> reviews;

    private double rateAverage;

    private long reviewsCount;

}
