package com.example.review.mapper;

import com.example.review.controller.dto.CreateOptionRequestModel;
import com.example.review.model.Option;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OptionMapper {
    OptionMapper INSTANCE = Mappers.getMapper( OptionMapper.class );

    Option toOption(CreateOptionRequestModel createOptionRequestModel);


}
