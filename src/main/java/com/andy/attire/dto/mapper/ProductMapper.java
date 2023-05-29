package com.andy.attire.dto.mapper;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class ProductMapper extends BaseMapperAbs {

    public static ProductDto convertToDto(ProductEntity productEntity) {
        ModelMapper modelMapper = getModelMapper();
        TypeMap<ProductEntity, ProductDto> propertyMapper = modelMapper.createTypeMap(ProductEntity.class, ProductDto.class);
        propertyMapper.addMappings(mapper -> mapper.skip(ProductDto::setImages));
        return modelMapper.map(productEntity, ProductDto.class);
    }

    public static ProductEntity convertToEntity(ProductDto productDto) {
        return getModelMapper().map(productDto, ProductEntity.class);
    }

    public static ProductDto convertToDtoWithImages(ProductEntity productEntity) {
        return getModelMapper().map(productEntity, ProductDto.class);
    }
}
