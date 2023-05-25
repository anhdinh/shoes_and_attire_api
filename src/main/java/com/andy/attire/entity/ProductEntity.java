package com.andy.attire.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "\"discount_percentage\"")
    private Double discountPercentage;
    private Double rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
    @Column(name = "\"delete\"")
    private Boolean delete;
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<ProductImageEntity> images;

    public String toString(){
        return "product: Id:"+id +";Title"+ title;
    }


}
