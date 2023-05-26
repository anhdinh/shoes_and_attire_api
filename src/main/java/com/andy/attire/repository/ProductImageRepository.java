package com.andy.attire.repository;

import com.andy.attire.entity.ProductImageEntity;
import com.andy.attire.entity.resultset.ResultSet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductImageRepository extends CrudRepository<ProductImageEntity,Long> {
    @Query("SELECT new com.andy.attire.entity.resultset.ResultSet( c.id,c.product.brand) FROM ProductImageEntity c where c.id=:id")
    ResultSet countData(@Param("id") Long id);
}
