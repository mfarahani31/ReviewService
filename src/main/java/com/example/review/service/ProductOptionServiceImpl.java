package com.example.review.service;

import com.example.review.model.ProductOption;
import com.example.review.repository.ProductOptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
@Service
public class ProductOptionServiceImpl implements ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public ProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public ProductOption save(Long productId, ProductOption productOption) {
        try {
            productOption.setProductId(productId);
            return this.productOptionRepository.save(productOption);
        } catch (
                HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ProductOption getByProductId(Long productId) {
        try {
            return this.productOptionRepository.findByProductId(productId);
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
