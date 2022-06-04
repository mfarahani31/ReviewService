package com.example.review.controller.dto;

import com.example.review.model.enums.ReviewStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResponseModel {
    private Long id;

    private String comment;

    private Integer rate;

    private ReviewStatus status;

    private Long userId;

    private Long productId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
