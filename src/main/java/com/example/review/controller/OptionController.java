package com.example.review.controller;


import com.example.review.controller.dto.CreateOptionRequestModel;
import com.example.review.mapper.OptionMapper;
import com.example.review.model.Option;
import com.example.review.service.OptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/options")
public class OptionController {

    private final OptionServiceImpl optionService;

    @Autowired
    public OptionController(OptionServiceImpl optionService) {
        this.optionService = optionService;
    }

    @PostMapping
    public ResponseEntity<Option> saveOption(@RequestBody CreateOptionRequestModel createOptionRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.optionService.save(OptionMapper.INSTANCE.toOption(createOptionRequestModel)));

    }


}
