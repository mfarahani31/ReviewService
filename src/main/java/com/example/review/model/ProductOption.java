package com.example.review.model;


import com.example.review.model.enums.CommentStatus;
import com.example.review.model.enums.VoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_OPTIONS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOption extends BaseEntity {


    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_VISIBILITY")
    private Boolean productVisibility;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "COMMENT_STATUS")
    private CommentStatus commentStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "VOTE_STATUS")
    private VoteStatus voteStatus;

}
