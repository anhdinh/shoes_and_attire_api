package com.andy.attire.dto;

import com.andy.attire.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    public ProductDto(ProductEntity productEntity) {
        this.id= productEntity.getId();
        this.title = productEntity.getTitle();
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        this.discountPercentage = productEntity.getDiscountPercentage();
        this.rating = productEntity.getRating();
        this.stock = productEntity.getStock();
        this.category = productEntity.getCategory();
        this.thumbnail = productEntity.getThumbnail();
        this.delete = productEntity.isDelete();
        this.brand = productEntity.getBrand();
    }
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
