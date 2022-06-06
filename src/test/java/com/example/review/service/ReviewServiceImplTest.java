package com.example.review.service;

import com.example.review.MotherObject;
import com.example.review.model.Review;
import com.example.review.model.enums.ReviewStatus;
import com.example.review.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ReviewServiceImplTest {

    @InjectMocks
    ReviewServiceImpl reviewService;

    @Mock
    ReviewRepository reviewRepository;

    Review review;
    List<Review> reviews;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        review = MotherObject.getAnyReview();
        reviews = MotherObject.getAnyListOfReviews();
    }

    @Test
    void testContext() {
        assertNotNull(reviewService);
        assertNotNull(reviewRepository);
    }

    @Test
    void save() {
        reviewService.save(this.review);

        verify(reviewRepository, times(1)).save(this.review);
    }

    @Test
    void getById() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(this.review));

        Review review = reviewService.getById(1L).get();

        assertEquals("So good!!!", review.getComment());
        assertEquals(3, review.getRate());
        assertEquals(ReviewStatus.CONFIRMED, review.getStatus());
        assertEquals(1L, review.getProductId());
    }

    @Test
    void getAllReviewsByProductId() {
        when(reviewRepository.findAllByProductId(1L)).thenReturn(this.reviews);

        List<Review> reviews = reviewService.getAllReviewsByProductId(1L);

        assertEquals("Bad", reviews.get(1).getComment());
        assertEquals(ReviewStatus.REJECTED, reviews.get(1).getStatus());
    }


}