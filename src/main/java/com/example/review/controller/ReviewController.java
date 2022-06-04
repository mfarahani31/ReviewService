package com.example.review.controller;


import com.example.review.controller.dto.CreateReviewRequestModel;
import com.example.review.controller.dto.ReviewResponseModel;
import com.example.review.mapper.ReviewMapper;
import com.example.review.model.enums.ReviewStatus;
import com.example.review.service.LastThreeReviewForAProductModel;
import com.example.review.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewResponseModel> save(@RequestBody CreateReviewRequestModel createReviewRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ReviewMapper.INSTANCE.toReviewResponseModel(this.reviewService.save(ReviewMapper.INSTANCE.toReview(createReviewRequestModel))));
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseModel>> getAllReviews() {
        return ResponseEntity.status(HttpStatus.OK).
                body(ReviewMapper.INSTANCE.toReviewResponseModelList(this.reviewService.getAll()));
    }

    @GetMapping("/last3ReviewsByProductId/{productId}")
    public ResponseEntity<LastThreeReviewForAProductModel> getLast3ReviewsByProductId(@PathVariable Long productId) {
        return ResponseEntity.status(HttpStatus.OK).
                body(this.reviewService.getLast3viewsByProductId(productId));
    }

    @PutMapping("/updateStatusById/{reviewId}/{status}")
    public ResponseEntity<ReviewResponseModel> updateStatusById(@PathVariable Long reviewId, @PathVariable ReviewStatus status) {
        return ResponseEntity.status(HttpStatus.OK).
                body(ReviewMapper.INSTANCE.toReviewResponseModel(this.reviewService.updateStatusById(reviewId, status)));
    }


}
