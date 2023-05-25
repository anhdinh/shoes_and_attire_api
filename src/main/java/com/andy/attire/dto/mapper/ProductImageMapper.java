package com.andy.attire.dto.mapper;

import com.andy.attire.dto.ProductImageDto;
import com.andy.attire.entity.ProductImageEntity;

public class ProductImageMapper extends BaseMapperAbs {
    public static ProductImageDto convertToDto(ProductImageEntity productImageEntity){
        return modelMapper.map(productImageEntity, ProductImageDto.class);
    }

    public static ProductImageEntity convertToEntity(ProductImageDto productDto){
        return modelMapper.map(productDto, ProductImageEntity.class);
    }
}
