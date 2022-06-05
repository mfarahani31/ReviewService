package com.example.review.service;

import com.example.review.model.ProductOption;
import com.example.review.repository.ProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public ProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public ProductOption save(Long productId, ProductOption productOption) {
        productOption.setProductId(productId);
        return this.productOptionRepository.save(productOption);
    }

    @Override
    public ProductOption getByProductId(Long productId) {
        return this.productOptionRepository.findByProductId(productId);
    }
}
