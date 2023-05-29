package com.andy.attire.repository;

import com.andy.attire.entity.ProductEntity;
import com.andy.attire.entity.resultset.ProductResultSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT DISTINCT p FROM ProductEntity p left join FETCH p.images where p.id=:id")
    ProductEntity getSingleProductById(@Param("id") Long id);

    @Query("select new com.andy.attire.entity.resultset.ProductResultSet(p,avg(r.vote))" +
            " " +
            "from ProductEntity p " +
            "right join RattingEntity r " +
            "on p.id = r.product.id " +
            "group by p.id " +
            "having avg(r.vote) > 3 " +
            "order by avg(r.vote) desc")
    Page<ProductResultSet> getMostWantedProduct(PageRequest pageRequest);
}
