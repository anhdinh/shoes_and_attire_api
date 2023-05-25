package com.andy.attire.service.impl;

import com.andy.attire.dto.ErrorDto;
import com.andy.attire.dto.mapper.ErrorMapper;
import com.andy.attire.entity.ErrorEntity;
import com.andy.attire.repository.ErrorRepository;
import com.andy.attire.service.ErrorService;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService {
    private final ErrorRepository errorRepository;

    public ErrorServiceImpl(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    public ErrorDto saveError(ErrorDto errorDto) {
        ErrorEntity errorEntity = ErrorMapper.convertToEntity(errorDto);
        return ErrorMapper.convertToDto(errorRepository.save(errorEntity));
    }
}
