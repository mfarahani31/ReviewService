package com.example.review.controller.dto;

import lombok.Data;

@Data
public class CreateReviewRequestModel {
    private Long productId;
    private String comment;
    private Integer rate;
}
