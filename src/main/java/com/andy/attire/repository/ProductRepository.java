package com.andy.attire.repository;

import com.andy.attire.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("SELECT DISTINCT p FROM ProductEntity p left join FETCH p.images where p.id=:id")
    ProductEntity getSingleProductById(@Param("id") Long id);

}
