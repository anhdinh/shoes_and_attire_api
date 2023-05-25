package com.andy.attire.dto.mapper;

import com.andy.attire.dto.ErrorDto;
import com.andy.attire.entity.ErrorEntity;

public class ErrorMapper extends BaseMapperAbs {

    public static ErrorDto convertToDto(ErrorEntity errorEntity){
        return modelMapper.map(errorEntity, ErrorDto.class);
    }
    public static ErrorEntity convertToEntity(ErrorDto errorDto){
        return modelMapper.map(errorDto, ErrorEntity.class);
    }
}
