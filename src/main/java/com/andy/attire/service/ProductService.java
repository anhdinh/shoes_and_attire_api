package com.andy.attire.service;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.dto.response.ProductResponseDto;

import java.util.Optional;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    ProductDto editProduct(ProductDto productDto);

    Optional<ProductDto> getSingleProductById(Long productId);

    ProductResponseDto getProducts(int page, int pageSize);
}
