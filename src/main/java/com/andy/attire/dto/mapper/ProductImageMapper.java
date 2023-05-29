package com.andy.attire.dto.mapper;

import com.andy.attire.dto.ProductImageDto;
import com.andy.attire.entity.ProductImageEntity;

public class ProductImageMapper extends BaseMapperAbs {
    public static ProductImageDto convertToDto(ProductImageEntity productImageEntity){
        return getModelMapper().map(productImageEntity, ProductImageDto.class);
    }

    public static ProductImageEntity convertToEntity(ProductImageDto productDto){
        return getModelMapper().map(productDto, ProductImageEntity.class);
    }
}
