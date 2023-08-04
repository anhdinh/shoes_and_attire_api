package com.andy.attire.repository;

import com.andy.attire.entity.ProductImageEntity;
import com.andy.attire.entity.resultset.ResultSet;
import com.andy.attire.entity.resultset.ResultSetInterface;
import jakarta.persistence.Tuple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductImageRepository extends CrudRepository<ProductImageEntity,Long> {
    @Query(name = "find_data",nativeQuery = true)
    ResultSet usingSqlResultSetMapping(@Param("id") Long id);

    @Query("SELECT count(*) as count FROM ProductImageEntity")
    ResultSetInterface countInterfaceProjection(@Param("id") Long id);

    @Query("SELECT new com.andy.attire.entity.resultset.ResultSet( c.id,c.product.brand) FROM ProductImageEntity c where c.id=:id")
    ResultSet directMappingToDto(@Param("id") Long id);

    @Query(value = "SELECT c.id,c.url as imgUrl FROM product_image c where c.id=:id",nativeQuery = true)
    Tuple findByUsingTuple(@Param("id") Long id);
}
