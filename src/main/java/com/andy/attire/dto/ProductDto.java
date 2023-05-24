package com.andy.attire.dto;

import com.andy.attire.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private List<String> images;
    private boolean delete;

}
