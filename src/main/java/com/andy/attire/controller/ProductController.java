package com.andy.attire.controller;

import com.andy.attire.dto.ProductDto;
import com.andy.attire.dto.response.ProductResponseDto;
import com.andy.attire.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService= productService;
    }

    @GetMapping
    public ResponseEntity<ProductResponseDto> getProducts(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) throws Exception{
        return response(productService.getProducts(page,pageSize));
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        return response(productService.saveProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        return response(productService.editProduct(productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDto>> getProductById(@PathVariable("id") Long productId){
        return response(productService.getSingleProductById(productId));
    }
}
