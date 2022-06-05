package com.example.review.service;

import com.example.review.model.ProductOption;
import com.example.review.repository.ProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductProductOptionServiceImpl implements ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public ProductProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public ProductOption save(ProductOption productOption) {
        return this.productOptionRepository.save(productOption);
    }
}
