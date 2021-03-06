package com.example.review.mapper;

import com.example.review.controller.dto.CreateOptionRequestModel;
import com.example.review.controller.dto.ProductOptionResponseModel;
import com.example.review.model.ProductOption;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductOptionMapper {
    ProductOptionMapper INSTANCE = Mappers.getMapper(ProductOptionMapper.class);

    ProductOption toProductOption(CreateOptionRequestModel createOptionRequestModel);

    ProductOptionResponseModel toProductResponseModel(ProductOption productOption);

}
