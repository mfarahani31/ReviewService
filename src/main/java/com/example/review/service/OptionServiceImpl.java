package com.example.review.service;

import com.example.review.model.Option;
import com.example.review.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Option save(Option option) {
        return this.optionRepository.save(option);
    }
}
