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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "\"description\"")
    private String description;
    private BigDecimal price;
    @Column(name = "\"discountPercentage\"")
    private Double discountPercentage;
    private Double rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
    @Column(name = "\"delete\"")
    private Boolean delete;
    @Transient
    private List<String> images;

    public String toString(){
        return "product: Id:"+id +";Title"+ title;
    }


}
