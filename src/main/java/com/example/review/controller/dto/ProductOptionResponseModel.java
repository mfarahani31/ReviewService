package com.example.review.controller.dto;

import com.example.review.model.enums.CommentStatus;
import com.example.review.model.enums.RateStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductOptionResponseModel {
    private Long id;

    private Boolean productVisibility;

    private CommentStatus commentStatus;

    private RateStatus rateStatus;

    private Long productId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
