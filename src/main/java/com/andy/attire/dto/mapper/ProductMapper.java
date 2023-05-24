package com.andy.attire.dto.mapper;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.entity.ProductEntity;

public class ProductMapper extends BaseMapperAbs{

   public static ProductDto convertToDto(ProductEntity productEntity){
       return modelMapper.map(productEntity, ProductDto.class);
    }

    public static ProductEntity convertToEntity(ProductDto productDto){
        return modelMapper.map(productDto, ProductEntity.class);
    }
}
