package com.andy.attire.controller;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.dto.response.ProductResponseDto;
import com.andy.attire.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService= productService;
    }

    @GetMapping
    public ProductResponseDto getProducts(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize){
        return productService.getProducts(page,pageSize);
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return productService.editProduct(productDto);
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProductById(@PathVariable("id") Long productId){
        return productService.getSingleProductById(productId);
    }
}
