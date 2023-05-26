package com.andy.attire.entity;

import com.andy.attire.entity.resultset.ResultSet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_image")
@NamedNativeQuery(
        name = "find_data",
        query = "SELECT c.id,c.url as imgUrl FROM product_image c where c.id=:id",
        resultSetMapping = "imageMapToResultSet"
)
@SqlResultSetMapping(name="imageMapToResultSet",classes = @ConstructorResult(
        targetClass = ResultSet.class,
        columns = {
                @ColumnResult(name="id",type = Long.class),
                @ColumnResult(name = "imgUrl")
        }
))
public class ProductImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=true)
    @JsonBackReference
    private ProductEntity product;

}
