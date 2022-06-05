package com.example.review.service;

import com.example.review.model.ProductOption;

public interface ProductOptionService {
    ProductOption save(Long productId, ProductOption productOption);

    ProductOption getByProductId(Long productId);
}
