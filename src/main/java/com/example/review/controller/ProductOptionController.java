package com.example.review.controller;


import com.example.review.controller.dto.CreateOptionRequestModel;
import com.example.review.mapper.ProductOptionMapper;
import com.example.review.model.ProductOption;
import com.example.review.service.ProductProductOptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/options")
public class ProductOptionController {

    private final ProductProductOptionServiceImpl optionService;

    @Autowired
    public ProductOptionController(ProductProductOptionServiceImpl optionService) {
        this.optionService = optionService;
    }

    @PostMapping
    public ResponseEntity<ProductOption> saveOption(@RequestBody CreateOptionRequestModel createOptionRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.optionService.save(ProductOptionMapper.INSTANCE.toOption(createOptionRequestModel)));

    }


}
