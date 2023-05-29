package com.andy.attire.service.impl;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.dto.mapper.ProductImageMapper;
import com.andy.attire.entity.ProductImageEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import com.andy.attire.entity.ProductEntity;
import org.springframework.stereotype.Service;
import com.andy.attire.service.ProductService;
import com.andy.attire.dto.mapper.ProductMapper;
import org.springframework.data.domain.PageRequest;
import com.andy.attire.repository.ProductRepository;
import com.andy.attire.dto.response.ProductResponseDto;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProducts(int page, int pageSize) throws Exception {
        // client-side page starts at 1 however, JPA begins at 0;
        page = page - 1;
        var productResponseDto = new ProductResponseDto();
        Page<ProductEntity> pageEntity = productRepository.findAll(PageRequest.of(page, pageSize));
        List<ProductDto> productDtoList = pageEntity.stream().map(ProductMapper::convertToDto).toList();
        productResponseDto.setProducts(productDtoList);
        productResponseDto.setTotal(pageEntity.getTotalElements());
        return productResponseDto;
    }

    @Override
    public Optional<ProductDto> getSingleProductById(Long productId) {
        Optional<ProductDto> productDtoOptional;
        var productEntityOptional = productRepository.findById(productId);
        productDtoOptional = productEntityOptional.map(ProductMapper::convertToDtoWithImages);
        return productDtoOptional;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.convertToEntity(productDto);
        return ProductMapper.convertToDto(productRepository.save(productEntity));
    }

    @Override
    public ProductDto editProduct(ProductDto productDto) {
        var productEntity = productRepository.save(ProductMapper.convertToEntity(productDto));
        return ProductMapper.convertToDto(productEntity);
    }

}
