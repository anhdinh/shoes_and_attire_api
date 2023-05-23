package com.andy.attire.entity;

import com.andy.attire.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    public ProductEntity(ProductDto productDto){
        this.id= productDto.getId();
        this.title = productDto.getTitle();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.discountPercentage = productDto.getDiscountPercentage();
        this.rating = productDto.getRating();
        this.stock = productDto.getStock();
        this.category = productDto.getCategory();
        this.thumbnail = productDto.getThumbnail();
        this.delete =  productDto.isDelete();
        this.brand = productDto.getBrand();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "\"description\"")
    private String description;
    private BigDecimal price;
    @Column(name = "\"discountPercentage\"")
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    @Column(name = "\"delete\"")
    private boolean delete;
    @Transient
    private List<String> images;

    public String toString(){
        return "product: Id:"+id +";Title"+ title;
    }


}
