package com.example.review.controller.dto;

import com.example.review.model.enums.CommentStatus;
import com.example.review.model.enums.RateStatus;
import lombok.Data;

@Data
public class CreateOptionRequestModel {
    private Boolean productVisibility;
    private CommentStatus commentStatus;
    private RateStatus rateStatus;
}
