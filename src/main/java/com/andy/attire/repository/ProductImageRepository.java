package com.andy.attire.repository;

import com.andy.attire.entity.ProductImageEntity;
import com.andy.attire.entity.resultset.ResultSet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductImageRepository extends CrudRepository<ProductImageEntity,Long> {
    @Query("SELECT count(*) as count FROM ProductImageEntity")
    ResultSet countData();
}
