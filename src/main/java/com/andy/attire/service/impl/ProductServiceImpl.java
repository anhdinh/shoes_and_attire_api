package com.andy.attire.service.impl;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.dto.mapper.ProductMapper;
import com.andy.attire.dto.response.ProductResponseDto;
import com.andy.attire.entity.ProductEntity;
import com.andy.attire.repository.ProductRepository;
import com.andy.attire.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProducts(int page, int pageSize) {

        var productResponseDto =  new ProductResponseDto();
        var count = productRepository.count();
        var offset = (page - 1) * pageSize;
        var optionalProductEntities = productRepository.getProducts(offset, pageSize);

        productResponseDto.setTotal(count);
        if (optionalProductEntities.isPresent()){
           var listEntities =  optionalProductEntities.get();
           var listDtos =  listEntities.stream().map(ProductMapper::convertToDto).toList();
           productResponseDto.setProducts(listDtos);

        }
        return productResponseDto;
    }

    @Override
    public Optional<ProductDto> getSingleProductById(Long productId) {
        Optional<ProductDto> productDtoOptional;
        var productEntityOptional = productRepository.findById(productId);
        productDtoOptional = productEntityOptional.map(ProductMapper::convertToDto);
        return productDtoOptional;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.convertToEntity(productDto);
        productDto = new ProductDto(productRepository.save(productEntity));
        return productDto;
    }

    @Override
    public ProductDto editProduct(ProductDto productDto) {
        var productEntity = productRepository.save(ProductMapper.convertToEntity(productDto));
        return new ProductDto(productEntity);
    }


}
