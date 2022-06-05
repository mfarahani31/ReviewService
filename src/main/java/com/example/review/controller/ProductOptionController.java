package com.example.review.controller;


import com.example.review.controller.dto.CreateOptionRequestModel;
import com.example.review.controller.dto.ProductOptionResponseModel;
import com.example.review.mapper.ProductOptionMapper;
import com.example.review.service.ProductOptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews/options")
public class ProductOptionController {

    private final ProductOptionServiceImpl productOptionService;

    @Autowired
    public ProductOptionController(ProductOptionServiceImpl productOptionService) {
        this.productOptionService = productOptionService;
    }

    @PostMapping("/{productId}")
    public ResponseEntity<ProductOptionResponseModel> saveOptionForAProduct(@PathVariable Long productId, @RequestBody CreateOptionRequestModel createOptionRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ProductOptionMapper.INSTANCE.toProductResponseModel(this.productOptionService.save(productId, ProductOptionMapper.INSTANCE.toProductOption(createOptionRequestModel))));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductOptionResponseModel> getByProductId(@PathVariable Long productId) {
        return ResponseEntity.status(HttpStatus.OK).
                body(ProductOptionMapper.INSTANCE.toProductResponseModel(this.productOptionService.getByProductId(productId)));

    }


}
