package com.example.review.mapper;

import com.example.review.controller.dto.CreateReviewRequestModel;
import com.example.review.controller.dto.ReviewResponseModel;
import com.example.review.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper( ReviewMapper.class );

    Review toReview(CreateReviewRequestModel createReviewRequestModel);

    ReviewResponseModel toReviewResponseModel(Review review);

    List<ReviewResponseModel> toReviewResponseModelList(List<Review> reviews);
}
