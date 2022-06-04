package com.example.review.model;

import com.example.review.model.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "REVIEWS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review extends BaseEntity {

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "RATE")
    private Integer rate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "REVIEW_STATUS")
    private ReviewStatus status = ReviewStatus.PENDING;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

}
