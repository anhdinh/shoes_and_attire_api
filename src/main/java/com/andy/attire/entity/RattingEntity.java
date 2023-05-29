package com.andy.attire.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RATTING")
public class RattingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1)
    private Integer vote;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public String toString(){
        return "ratting:"+id+" vote:"+vote;
    }

}
