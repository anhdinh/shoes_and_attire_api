package com.andy.attire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String title;
    private String description;
    private BigDecimal price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private boolean delete;
    private List<ProductImageDto> images;

}
