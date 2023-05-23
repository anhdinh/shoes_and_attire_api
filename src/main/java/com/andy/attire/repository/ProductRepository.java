package com.andy.attire.repository;

import com.andy.attire.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity,Long> {
    @Query(value = "SELECT * FROM product limit ?,?",nativeQuery = true)
    Optional<List<ProductEntity>> getProducts(int offset, int row);
}
