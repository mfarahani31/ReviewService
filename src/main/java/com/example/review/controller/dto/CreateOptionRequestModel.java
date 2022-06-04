package com.example.review.controller.dto;

import lombok.Data;

@Data
public class CreateOptionRequestModel {
    private Long productId;
    private Boolean productVisibility;
    private String commentStatus;
    private String voteStatus;
}
