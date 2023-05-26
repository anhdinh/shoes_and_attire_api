package com.andy.attire.repository;

import com.andy.attire.entity.ProductImageEntity;
import com.andy.attire.entity.resultset.ResultSet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductImageRepository extends CrudRepository<ProductImageEntity,Long> {
    @Query(name = "find_data",nativeQuery = true)
    ResultSet countData(@Param("id") Long id);
}
