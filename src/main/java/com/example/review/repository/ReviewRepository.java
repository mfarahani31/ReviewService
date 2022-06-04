package com.example.review.repository;

import com.example.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(nativeQuery = true,
            value = "SELECT avg(r.rate) as average ,count(r.id) as reviewsCount  FROM REVIEWS r WHERE r.PRODUCT_ID = :productId AND r.REVIEW_STATUS = 1")
    AverageAndCountOfReviews getAverageAndCountOfReviews(@Param("productId") Long productId);

    @Query(nativeQuery = true, value = "SELECT top(3) * from REVIEWS r where r.PRODUCT_ID = :productId and r.REVIEW_STATUS = 1 order by r.CREATED_AT desc")
    List<Review> getLastThreeReviews(@Param("productId") Long productId);

}
