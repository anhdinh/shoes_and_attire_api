package com.andy.attire.entity.resultset;

import com.andy.attire.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductResultSet {
    public ProductResultSet(ProductEntity product, Double vote) {
        this.product = product;
        this.vote = vote;
    }

    ProductEntity product;
    Double vote;
}
