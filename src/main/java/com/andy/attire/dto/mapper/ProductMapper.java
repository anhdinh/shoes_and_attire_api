package com.andy.attire.dto.mapper;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.entity.ProductEntity;

public class ProductMapper {
   public static ProductDto convertToDto(ProductEntity productEntity){
        return new ProductDto(productEntity);
    }

    public static ProductEntity convertToEntity(ProductDto productDto){
        return new ProductEntity(productDto);
    }
}
